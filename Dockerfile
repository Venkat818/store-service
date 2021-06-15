FROM openjdk:8-jre-alpine
WORKDIR /app
COPY target/store-service.jar /app
CMD chmod +774 store-service.jar
EXPOSE 9080
CMD sleep 10 && java -jar store-service.jar
