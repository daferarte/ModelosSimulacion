# Usamos la imagen de eclipse temurin ya que tiene java y maven
FROM maven:3.9.11-eclipse-temurin-17

# Directorio de trabajo
WORKDIR /app

# copiar el pom.xml y descargamos las dependencias 
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar codigo fuente
COPY src ./src

#Ejecutar el proyecto
ENTRYPOINT [ "mvn", "spring-boot:run" ]

