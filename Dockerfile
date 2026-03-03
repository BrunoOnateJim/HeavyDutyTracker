FROM eclipse-temurin:17-jre-alpine
COPY heavy-duty-tracker-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Dserver.port=${PORT:8080}", "-jar", "/app.jar"]
