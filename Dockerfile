# Build stage
FROM maven:3.8.2-openjdk-22 AS build

COPY target/EconovaSpring-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
