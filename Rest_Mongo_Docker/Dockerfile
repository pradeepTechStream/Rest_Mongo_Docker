# Use OpenJDK 17 as base image
FROM eclipse-temurin:17-jdk-alpine
# Set working directory
WORKDIR /app
# Copy Maven build output
COPY target/Rest_Mongo_Docker-0.0.1-SNAPSHOT.jar app.jar
# Expose app port
EXPOSE 8080
# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]