# Use an available Maven + OpenJDK image to build the app
FROM maven:3.9.6-eclipse-temurin-17 AS build





# Set working directory
WORKDIR /app

# Copy app source code
COPY . .

# Build the project (skip tests to speed up)
RUN mvn clean package -DskipTests

# Use a lightweight OpenJDK image to run the app
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the JAR from the build image
COPY --from=build /app/target/guessing-game-1.0.0.jar .

# Run the application
CMD ["java", "-jar", "guessing-game-1.0.0.jar"]

