FROM eclipse-temurin:17-jre-alpine

# Copiamos el archivo ejecutable
COPY heavy-duty-tracker-0.0.1-SNAPSHOT.jar app.jar

# Inyectamos TODA la configuración necesaria en el arranque
# Esto sustituye al archivo application.properties por si no lo encuentra
ENTRYPOINT ["java", \
            "-Dserver.port=${PORT:8080}", \
            "-Dspring.main.allow-bean-definition-overriding=true", \
            "-Dspring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration", \
            "-Xmx256m", \
            "-jar", "/app.jar"]
