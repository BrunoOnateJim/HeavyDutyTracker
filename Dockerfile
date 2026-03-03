# Usamos una imagen que ya tiene todo listo para no descargar nada extra
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
# Compilamos de forma súper ligera
RUN mvn clean package -DskipTests -Dmaven.test.skip=true

FROM openjdk:17-jdk-slim
COPY --from=build /target/*.jar app.jar
# Le decimos a Java que use poca memoria RAM
ENTRYPOINT ["java", "-Xmx512m", "-jar", "/app.jar"]
