# codbex-atlas-tomcat

The `codbex` atlas `tomcat` package

To build the docker image:

    docker build -t codbex-atlas-tomcat:latest .

To run a container:

    docker run --name codbex --rm -p 8080:8080 -p 8081:8081 codbex-atlas-tomcat:latest

To tag the image:

    docker tag codbex-atlas-tomcat codbex.jfrog.io/codbex-docker/codbex-atlas-tomcat:latest

To push to JFrog Container Registry:

    docker push codbex.jfrog.io/codbex-docker/codbex-atlas-tomcat:latest

To pull from JFrog Container Registry:

    docker pull codbex.jfrog.io/codbex-docker/codbex-atlas-tomcat:latest
