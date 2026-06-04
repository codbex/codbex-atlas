# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## What this is

Atlas is a **packaging/distribution project**, not a standalone codebase. It assembles the "Atlas Edition" — a Spring Boot application that bundles all standard [Eclipse Dirigible](https://www.eclipse.dev/dirigible/) components (the low-code/in-app development platform) plus codbex branding and a couple of custom UI components. Almost all behavior lives in the `org.eclipse.dirigible` dependencies pulled in via the `com.codbex.platform:codbex-platform-parent` parent POM; this repo mostly selects which Dirigible component groups to include and configures/brands them.

Implication: when investigating runtime behavior or APIs, the answer is usually in the Dirigible dependencies (the `dirigible-components-*` artifacts), not in this repo's source. This repo has only a handful of Java files.

## Build & run

Requires JDK 21 (Amazon Corretto in the Docker image). Maven profiles `quick-build`, `unit-tests`, `integration-tests`, `tests`, and `format` are inherited from the platform parent POM.

```shell
mvn -T 1C clean install -P quick-build   # fast build, skips tests — produces the runnable jar
mvn clean install -P unit-tests          # unit tests
mvn clean install -P integration-tests   # integration tests (Selenide UI + API; slow)
mvn clean install -P tests               # all tests
mvn verify -P format                     # apply code formatting (codbex-formatter.xml)
```

Run the built jar (the `--add-opens` flags are required):

```shell
java \
    --add-opens=java.base/java.lang=ALL-UNNAMED \
    --add-opens=java.base/java.lang.reflect=ALL-UNNAMED \
    --add-opens=java.base/java.nio=ALL-UNNAMED \
    -jar application/target/codbex-atlas-*.jar
```

Add `-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000` for debugging on port 8000.

App serves on **port 80** (`application-app-default.properties`). Default login `admin`/`admin`. UI at http://localhost:80, REST/Swagger at http://localhost/swagger-ui/index.html.

### Run a single integration test

Integration tests are JUnit 5 (`*IT.java`). Run one with the standard Maven test selector under the integration-tests profile, e.g.:

```shell
mvn clean install -P integration-tests -pl integration-tests -Dit.test=HomePageIT
```

Note `DirigibleCommonTestSuiteIT` is a `@Suite` that aggregates a large set of Dirigible's own `*IT` classes by reference — it's where most of the integration coverage actually comes from.

## Module layout

Maven reactor modules (see root `pom.xml`):

- **application** — the Spring Boot app. `AtlasApplication` is a `@SpringBootApplication` that scans `org.eclipse.dirigible` and excludes Spring's datasource/JPA auto-config (Dirigible manages its own datasources). Its `pom.xml` is the real definition of the edition: it lists every Dirigible component group included (core, security, database, engines, IDE backend/UI, APIs, templates) and the bundled JDBC drivers (Postgres, MongoDB, SAP HANA `ngdbc`, Snowflake, H2). The Spring Boot repackage produces the runnable jar. Also contains the `Dockerfile`.
- **branding** — codbex/Atlas logo, favicon, and `project.json` packaged as Dirigible resources under `META-INF/dirigible/atlas-branding/`.
- **components/ui/menu-help** and **components/ui/view-welcome** — custom Dirigible UI components that *override* the stock Dirigible ones (the stock `dirigible-components-ui-menu-help` and `dirigible-components-ui-view-welcome` are explicitly excluded in `application/pom.xml`). These are resource-only modules (HTML/JS + `.extension`/`config` files under `META-INF/dirigible/`), no Java.
- **integration-tests** — Selenide-based UI and API integration tests against the assembled application.

## Configuration model

Two layers of config:

- **Spring** (`application*.properties`): `spring.profiles.active=common,app-default`. To enable Dirigible features you must activate the `common` and `app-default` profiles explicitly, plus any extra (e.g. `SPRING_PROFILES_ACTIVE=common,snowflake,app-default`).
- **Dirigible** (`dirigible.properties`): `DIRIGIBLE_*` env-style keys control branding, instance name, multi-tenancy (`DIRIGIBLE_MULTI_TENANT_MODE=false`), ports, etc. Values like `${project.version}` / `${git.commit.id}` are filled at build time.

## Conventions

- Java source files carry the EPL-2.0 license header (see existing files); the `format` profile and `licensing-header.txt` enforce this — run `mvn verify -P format` before committing rather than hand-editing headers.
- Releases bump the version in all POMs together (the project version is `3.0.0-SNAPSHOT` during development); the Helm chart under `helm/` is versioned in lockstep (see recent git history).
