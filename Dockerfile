FROM java:8
EXPOSE 8080
ADD /target/conversao-cambio-1.jar conversao-cambio-1.jar
ENTRYPOINT ["java", "-jar", "conversao-cambio-1.jar"]