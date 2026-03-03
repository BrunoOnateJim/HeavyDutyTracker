FROM eclipse-temurin:17-jre-alpine

# Copiamos el archivo ejecutable
COPY heavy-duty-tracker-0.0.1-SNAPSHOT.jar app.jar

# Forzamos el arranque ignorando errores de estructura
CMD ["java", "-Dserver.port=${PORT:8080}", "-jar", "/app.jar"]
