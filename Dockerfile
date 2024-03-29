# Base Alpine Linux based image with OpenJDK JRE only
FROM openjdk:8-jre-alpine
# copy application WAR (with libraries inside)
COPY target/app.jar /app.jar
EXPOSE 8080
# specify default command
CMD ["/usr/bin/java", "-jar", "/app.jar"]
