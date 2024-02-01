FROM amazoncorretto:17.0.7-alpine

EXPOSE 8082

ARG RESOURCE_JAR_FILE=target/Resource-Service-0.0.1-SNAPSHOT.jar

COPY ${RESOURCE_JAR_FILE} ./resourceService.jar

ENTRYPOINT ["java", "-jar", "resourceService.jar"]