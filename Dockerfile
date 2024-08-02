FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/sinergiarh-challenge.jar
COPY ${JAR_FILE} sinergiarh-challenge.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "sinergiarh-challenge.jar"]