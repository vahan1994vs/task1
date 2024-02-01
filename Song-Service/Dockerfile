FROM amazoncorretto:17.0.7-alpine

EXPOSE 8081

ARG SONG_JAR_FILE=target/Song-Service-0.0.1-SNAPSHOT.jar

COPY ${SONG_JAR_FILE} ./songService.jar

ENTRYPOINT ["java", "-jar", "songService.jar"]
