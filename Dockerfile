# Use a Maven Docker image as the base
FROM maven:3.8.4-openjdk-17-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project's pom.xml file to the container
COPY pom.xml .

# Download and install Maven dependencies
RUN mvn dependency:go-offline

# Copy the entire source code to the container
COPY . .

# Build the Maven project
RUN mvn package

# Define the command to run your application
CMD ["java", "-jar", "target/NoserVendingMachine-0.0.1-SNAPSHOT.jar"]
