# Build stage
FROM maven:3.8.2-openjdk-17 AS build

# Ejecuta el comando de construcción dentro de la imagen de Maven
COPY . .
RUN mvn clean package -DskipTests

# Package stage
FROM openjdk:17-jdk-slim AS runtime
COPY --from=build target/EconovaSpring-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
