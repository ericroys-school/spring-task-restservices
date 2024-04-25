# RESTFul Web Service for Tasking Using Spring

## Description

This is a simple Spring web service project that I've used for serving
up endpoints to test with various web service clients. It does not connect
to a database but uses simple in-memory repository for CRUD operations.

## The particulars

This is a maven project which means it has all the dependencies laid out in
pom.xml. You will need to have maven installed to build the project (the newer
the better) and Docker if you want to run it containerized (optional).
Java required is at least 11. I'm sure it will work with 8 if that's all you have. When running the webservice is available via port 9001 as specified in the application.yml configuration file.

## Installation

Clone the repo

##### `git clone https://github.com/ericroys-school/spring-task-restservices.git`

Build the project

##### `mvn clean install`

![alt text](/doc/compile.png "Happy Compile Result")

Run the Spring app

##### `java -jar target/tasking.jar`

#### Use Docker instead

Build the Docker image

##### `docker build -t tasking:latest -f Dockerfile ./target`

Run the container and use port 9001

##### `docker run -d --name tasking_ws -p 127.0.0.1:9001:9001/tcp tasking:latest`

Verify the container is running

##### `docker ps`

![alt text](/doc/docker_ps.png "Happy Container Running")

## Usage

The api specs are available via swagger once the app is running.

##### `http://127.0.0.1:9001/swagger-ui/index.html#/`
