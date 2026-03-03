FROM eclipse-temurin:17-jre-alpine
COPY heavy-duty-tracker-0.0.1-SNAPSHOT.jar app.jar
# Agregamos parámetros para que no se detenga por errores de escaneo
ENTRYPOINT ["java", "-Dserver.port=${PORT:8080}", "-Dspring.main.allow-bean-definition-overriding=true", "-jar", "/app.jar"]
