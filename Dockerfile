FROM openjdk:8-jdk-alpine

EXPOSE 8080

RUN mkdir -p /opt/abreutech/sgc

WORKDIR /app

ENV JAVA_OPTS=""

ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app/sgc-backend.jar

COPY target/sgc
-backend.jar .

