FROM openjdk:11
ARG JAR_FILE=target/CentralLoggerService.jar
COPY ${JAR_FILE} app.jar
EXPOSE 9999
ENTRYPOINT ["java","-jar","/app.jar"]