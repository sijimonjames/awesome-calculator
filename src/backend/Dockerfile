### STAGE 1: Build ###
FROM maven:3.8.1-openjdk-17-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY src/backend/pom.xml /workspace
COPY src/backend/src /workspace/src
RUN mvn clean package

### STAGE 2: Run ###
FROM openjdk:18-jdk-oracle
COPY --from=build /workspace/target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
