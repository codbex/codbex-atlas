# codbex-atlas

Atlas Platform contains all the available standard components.

It is good for exploration about the different features and their applicability in particular scenarios.

#### Build

	mvn clean install
	
#### Run

	java -jar components/app-all/target/codbex-atlas-components-application-all-0.1.0-SNAPSHOT.jar

#### Debug

	java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000 -jar components/app-all/target/codbex-atlas-components-application-all-0.1.0-SNAPSHOT.jar
	
#### REST API

	http://localhost:8080/swagger-ui/index.html


