# Use an official Maven image to build the app
FROM maven:3.8.7-openjdk-17 AS build

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/guessing-game-1.0.0.jar .

CMD ["java", "-jar", "guessing-game-1.0.0.jar"]
