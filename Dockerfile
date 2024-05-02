from ubuntu:latest as buid

Run apt-get update && apt-get install -y openjdk-17-jdk

COPY . . 

Run apt-get install maven -y

Run mvn clean install

From openjdk-17-jdk-slim

Expose 8080

COPY --from=build /target/gamestore.jar /app.jar

entrypoint ["java", "-jar","app.jar"]