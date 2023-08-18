# codbex-atlas

Atlas Edition contains all the available standard components.

It is good for exploration about the different features and their applicability in particular scenarios.


#### Docker

```
docker pull ghcr.io/codbex/codbex-atlas:latest
docker run --name codbex-atlas --rm -p 80:80 ghcr.io/codbex/codbex-atlas:latest
```

- For Apple's M1: provide `--platform=linux/arm64` for better performance		

#### Build

```
mvn clean install
```
	
#### Run

```
java -jar application/target/codbex-atlas-application-*.jar
```

#### Debug

```
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000 -jar application/target/codbex-atlas-application-*.jar
```
	
#### Web

```
http://localhost
```

#### REST API

```
http://localhost/swagger-ui/index.html
```
