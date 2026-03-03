# Etapa 1: Compilación ultra ligera
FROM maven:3.8.5-openjdk-17-slim AS build
COPY . .
# Limitamos la memoria de Maven a 512MB para que no explote Render
ENV MAVEN_OPTS="-Xmx512m"
RUN mvn clean package -DskipTests --batch-mode

# Etapa 2: Ejecución
FROM eclipse-temurin:17-jre-alpine
COPY --from=build /target/*.jar app.jar
# Limitamos la memoria de la App al arrancar
ENTRYPOINT ["java", "-Xmx512m", "-jar", "/app.jar"]
