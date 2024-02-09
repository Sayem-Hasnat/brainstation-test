FROM openjdk:17-jdk-alpine
COPY ./target/brain-station-microservice-test.jar .
ENTRYPOINT ["java","-jar","brain-station-microservice-test.jar"]
EXPOSE 8080