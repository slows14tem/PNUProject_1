FROM eclipse-temurin:19-jdk-alpine
VOLUME /tmp
COPY *.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]