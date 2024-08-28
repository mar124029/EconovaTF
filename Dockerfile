#
# Build stage
#
FROM maven:3.8.2-eclipse-temurin-22 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM eclipse-temurin:22-jdk-slim
COPY --from=build /target/EconovaSpring-0.0.1-SNAPSHOT.jar demo.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]
