FROM openjdk:8-jdk-alpine
COPY target/conversao-cambio-1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]