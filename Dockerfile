# Base Alpine Linux based image with OpenJDK JRE only
FROM openjdk:8-jre-alpine
# copy application JAR (with libraries inside)
ENV VARIABLEFROMDOCKERFILE=IGOTIT
COPY target/app.jar /app.jar
EXPOSE 8080
# specify default command trigger
CMD ["/usr/bin/java", "-jar", "/app.jar"]
