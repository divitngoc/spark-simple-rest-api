FROM openjdk:11
VOLUME /tmp
COPY /target/spark-simple-rest-api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8800
ENTRYPOINT ["java","-jar","/app.jar"]