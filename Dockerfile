FROM openjdk:21-jdk-slim
ENV DB_URL=jdbc:mysql://u4xbhafwsx3z5lg0:BEbxLe6x7uSuhiTzZiPf@b7v2h0wyhihgvv2hla9q-mysql.services.clever-cloud.com:3306/b7v2h0wyhihgvv2hla9q
ENV DB_USER=u4xbhafwsx3z5lg0
ENV DB_PASS=BEbxLe6x7uSuhiTzZiPf
ARG JAR_FILE=target/sinergiarh-challenge.jar
COPY ${JAR_FILE} sinergiarh-challenge.jar
EXPOSE 10000
ENTRYPOINT ["java", "-jar", "sinergiarh-challenge.jar"]