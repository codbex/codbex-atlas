# Atlas by codbex

[![Build Status](https://github.com/codbex/codbex-atlas/actions/workflows/build.yaml/badge.svg)](https://github.com/codbex/codbex-atlas/actions/workflows/build.yaml)
[![Eclipse License](https://img.shields.io/badge/License-EPL%202.0-brightgreen.svg)](https://github.com/codbex/codbex-helios/blob/main/LICENSE)
[![Maven Central](https://img.shields.io/maven-central/v/com.codbex.atlas/codbex-atlas-application.svg)](https://central.sonatype.com/namespace/com.codbex.atlas)

Atlas Edition contains all the available standard components.

It is good for exploration about the different features and their applicability in particular scenarios.

<!-- TOC -->
* [codbex-atlas](#codbex-atlas)
    * [Run steps](#run-steps)
        * [Start using Docker and released image](#start-using-docker-and-released-image)
        * [Start using Docker and local sources](#start-using-docker-and-local-sources)
            * [Build the project jar](#build-the-project-jar)
            * [Build and run docker image locally](#build-and-run-docker-image-locally)
        * [Java standalone application](#java-standalone-application)
            * [Start the application](#start-the-application)
            * [Start the application **in debug** with debug port `8000`](#start-the-application-in-debug-with-debug-port-8000)
        * [Run unit tests](#run-unit-tests)
        * [Run integration tests](#run-integration-tests)
        * [Run all tests](#run-all-tests)
        * [Format the code](#format-the-code)
    * [Access the application](#access-the-application)
    * [REST API](#rest-api)
<!-- TOC -->

## Run steps

__Prerequisites:__
- Export the following variables before executing the steps
  ```shell
  export GIT_REPO_FOLDER='<path-to-the-git-repo>'
  export IMAGE='ghcr.io/codbex/codbex-atlas:latest'
  export CONTAINER_NAME='atlas'
  ```

### Start using Docker and released image

```shell
# optionally remove the existing container with that name
docker rm -f "$CONTAINER_NAME"
docker pull "$IMAGE"

docker run --name "$CONTAINER_NAME" -p 80:80 "$IMAGE"
```

---

### Start using Docker and local sources
#### Build the project jar
```shell
cd $GIT_REPO_FOLDER
mvn -T 1C clean install -P quick-build
```

#### Build and run docker image locally

__Prerequisites:__ [Build the project jar](#build-the-project-jar)

  ```shell
  cd "$GIT_REPO_FOLDER/application"
  
  docker build . --tag "$IMAGE"
  
  # optionally remove the existing container with that name
  docker rm -f "$CONTAINER_NAME"

  docker run --name "$CONTAINER_NAME" -p 80:80 "$IMAGE"
  ```

--- 

### Java standalone application
__Prerequisites:__ [Build the project jar](#build-the-project-jar)

#### Start the application
```shell
cd "$GIT_REPO_FOLDER"

java \
    --add-opens=java.base/java.lang=ALL-UNNAMED \
    --add-opens=java.base/java.lang.reflect=ALL-UNNAMED \
    --add-opens=java.base/java.nio=ALL-UNNAMED \
    -jar application/target/codbex-atlas-*.jar
```

#### Start the application **in debug** with debug port `8000`
```shell
cd "$GIT_REPO_FOLDER"

export PHOEBE_AIRFLOW_WORK_DIR="$AIRFLOW_WORK_DIR"
java \
    -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000 \
    --add-opens=java.base/java.lang=ALL-UNNAMED \
    --add-opens=java.base/java.lang.reflect=ALL-UNNAMED \
    --add-opens=java.base/java.nio=ALL-UNNAMED \
    -jar application/target/codbex-atlas-*.jar
```

---

### Run unit tests

```shell
cd "$GIT_REPO_FOLDER"
mvn clean install -P unit-tests
```

---

### Run integration tests

```shell
cd "$GIT_REPO_FOLDER"
mvn clean install -P integration-tests
```

---

### Run all tests

```shell
cd "$GIT_REPO_FOLDER"
mvn clean install -P tests
```

---

### Format the code

```shell
cd "$GIT_REPO_FOLDER"
mvn verify -P format
```

---

## Access the application
- Open URL [http://localhost:80](http://localhost:80)
- Login with the default credentials username `admin` and password `admin`

## REST API

```
http://localhost/swagger-ui/index.html
```
