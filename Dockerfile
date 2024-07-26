# Use the official OpenJDK image.
FROM openjdk:17

# Expose port 8080.
EXPOSE 8080

# Copy the jar file from the target directory to the container's working directory.
COPY ./target/SchoolMicroservice-0.0.1-SNAPSHOT.jar /app/SchoolMicroservice-0.0.1-SNAPSHOT.jar

# Set the working directory.
WORKDIR /app

# Define the entry point for the container.
ENTRYPOINT ["java", "-jar", "SchoolMicroservice-0.0.1-SNAPSHOT.jar"]

