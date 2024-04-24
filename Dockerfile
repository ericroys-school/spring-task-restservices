FROM eclipse-temurin:21-alpine
VOLUME /tmp
ADD tasking.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]