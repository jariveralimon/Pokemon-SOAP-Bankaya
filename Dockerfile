# Utilizar la imagen oficial de OpenJDK 17
FROM openjdk:17-jdk-slim

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR generado por Spring Boot al contenedor
COPY target/pokemon-0.0.1-SNAPSHOT.jar pokemon-service.jar

# Exponer el puerto 8080 y 9092 (opcional, para conexiones H2 remotas)
EXPOSE 8080 9092

# Configuración de base de datos H2
ENV SPRING_H2_CONSOLE_ENABLED=true
ENV SPRING_H2_CONSOLE_SETTINGS_WEB_ALLOW_OTHERS=true
ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:pokemondb
ENV SPRING_DATASOURCE_DRIVER_CLASS_NAME=org.h2.Driver
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "pokemon-service.jar"]
