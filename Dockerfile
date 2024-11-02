FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/*.jar app.jar

EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
