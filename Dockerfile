FROM openjdk:8-jdk-alpine
MAINTAINER experto.com
VOLUME /tmp
EXPOSE 8080
ADD target/springboot-apirest-0.0.1-SNAPSHOT.jar springboot-apirest-docker.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/springboot-apirest-docker.jar"]