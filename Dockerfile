# Etapa 1: Compilación
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución (Cambiamos openjdk por eclipse-temurin)
FROM eclipse-temurin:17-jre-alpine
COPY --from=build /target/*.jar app.jar
# Limitamos la memoria para que Render no se sature
ENTRYPOINT ["java", "-Xmx512m", "-jar", "/app.jar"]
