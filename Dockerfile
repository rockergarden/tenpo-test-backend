FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/criverostenpo-api-0.0.1.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
