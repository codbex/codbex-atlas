# codbex-atlas

Atlas Edition contains all the available standard components.

It is good for exploration about the different features and their applicability in particular scenarios.

#### Build

	mvn clean install
	
#### Run

	java -jar application/target/codbex-atlas-application-0.1.0-SNAPSHOT.jar

#### Debug

	java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000 -jar application/target/codbex-atlas-application-0.1.0-SNAPSHOT.jar
	
#### Web

	http://localhost:8080/

#### REST API

	http://localhost:8080/swagger-ui/index.html


