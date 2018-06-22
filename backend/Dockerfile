FROM openjdk:8-jre-alpine
EXPOSE 8080
COPY build/libs/photodump-gradle-1.0.jar photodump.jar
COPY entrypoint.sh entrypoint.sh
ENTRYPOINT "/entrypoint.sh"