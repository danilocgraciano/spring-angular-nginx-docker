# docker build -t  danilocgraciano/person:1.0 .
# docker run --publish=8080:8080 danilocgraciano/person:1.0
FROM openjdk:11-jre-slim
WORKDIR /opt/app
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","app.jar" ]