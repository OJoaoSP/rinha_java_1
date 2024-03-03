FROM openjdk:17

#Start application
WORKDIR /app

COPY target/rinha-0.0.1-SNAPSHOT.jar /app/rinha-api.jar

ENTRYPOINT ["java", "-jar", "rinha-api.jar"]