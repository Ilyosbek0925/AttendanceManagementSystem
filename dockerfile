FROM openjdk:21-slim
VOLUME /tmp
COPY target/HRMS-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
