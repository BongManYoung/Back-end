FROM openjdk:11-jdk
EXPOSE 8011
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Xmx200m", "-jar","/app.jar"]