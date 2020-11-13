FROM openjdk:8-jdk-alpine
MAINTAINER experto.com
VOLUME /tmp
EXPOSE 8080
ADD build/libs/itau-0.0.1-SNAPSHOT.jar itau.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/itau.jar"]