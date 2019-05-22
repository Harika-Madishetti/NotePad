FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=build/libs/NotePad-0.0.1-SNAPSHOT.jar
COPY build/libs/NotePad-0.0.1-SNAPSHOT.jar mynotes.jar
ENTRYPOINT ["java","-jar","/mynotes.jar"]
