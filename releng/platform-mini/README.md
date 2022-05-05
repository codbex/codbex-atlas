# codbex-platform-mini

The `codbex` platform `mini` package

To build the docker image:

    docker build -t codbex-platform-mini:latest .

To run a container:

    docker run --name codbex --rm -p 8080:8080 -p 8081:8081 codbex-platform-mini:latest

To tag the image:

    docker tag codbex-platform-mini codbex.jfrog.io/codbex-docker/codbex-platform-mini:latest

To push to JFrog Container Registry:

    docker push codbex.jfrog.io/codbex-docker/codbex-platform-mini:latest

To pull from JFrog Container Registry:

    docker pull codbex.jfrog.io/codbex-docker/codbex-platform-mini:latest
