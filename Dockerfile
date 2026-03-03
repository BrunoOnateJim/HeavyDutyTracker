FROM eclipse-temurin:17-jre-alpine

# Copiamos el ejecutable
COPY heavy-duty-tracker-0.0.1-SNAPSHOT.jar app.jar

# Forzamos el puerto y la memoria directamente en el comando de arranque
# Esto ignora si el archivo properties se encuentra o no
ENTRYPOINT ["java", "-Dserver.port=${PORT:8080}", "-Xmx256m", "-jar", "/app.jar"]
