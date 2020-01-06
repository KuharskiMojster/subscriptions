# Start with a base image containing Java runtime
FROM adoptopenjdk/openjdk11:latest

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=/target/subscriptions-1.0.0-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} subscriptions.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/subscriptions.jar"]
