# codbex-platform-all

The `codbex` platform `all` package

To build the docker image:

    docker build -t codbex-platform-all:latest .

To run a container:

    docker run --name codbex --rm -p 8080:8080 -p 8081:8081 codbex-platform-all:latest

To tag the image:

    docker tag codbex-platform-all codbex.jfrog.io/codbex-docker/codbex-platform-all:latest

To push to JFrog Container Registry:

    docker push codbex.jfrog.io/codbex-docker/codbex-platform-all:latest

To pull from JFrog Container Registry:

    docker pull codbex.jfrog.io/codbex-docker/codbex-platform-all:latest
