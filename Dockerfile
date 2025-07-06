# Construção do JAR com Maven
FROM maven:3.9.4-eclipse-temurin-21-alpine AS build
COPY . /home/app/gerenciador-contatos-backend
RUN mvn -f /home/app/gerenciador-contatos-backend/pom.xml clean package -DskipTests

# Imagem final só com Java e o JAR
FROM eclipse-temurin:21-jdk-alpine
COPY --from=build /home/app/gerenciador-contatos-backend/target/*.jar /usr/local/lib/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/app.jar"]
