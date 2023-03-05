FROM openjdk:8-jdk-alpine

WORKDIR /app

COPY build/libs/exchange-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "exchange-0.0.1-SNAPSHOT.jar"]