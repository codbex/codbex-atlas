# codbex-platform-mini

The `codbex` platform mini package

To build the docker image:

> docker build -t codbex-platform-mini:latest .

To run a container:

> docker run --name codbex --rm -p 8080:8080 -p 8081:8081 codbex-platform-mini:latest
