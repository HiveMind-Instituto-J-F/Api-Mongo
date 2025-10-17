# =============================
# Etapa 1: Build com Maven + JDK 21
# =============================
FROM maven:3.9.4-eclipse-temurin-21 AS builder

# Instala JDK
RUN apt-get update
RUN apt-get install openjdk-21-jdk -y

# Diretório de trabalho
WORKDIR /app

# Copia arquivos do projeto
COPY pom.xml .
COPY src ./src

# Build do projeto sem testar, sem resource filtering
RUN mvn clean install

# =============================
# Etapa 2: Runtime com JDK 21 slim
# =============================
FROM openjdk:21-jdk-slim
#FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copia o JAR gerado na etapa de build
COPY --from=builder /app/target/*.jar app.jar

# Porta que a API vai escutar
EXPOSE 27100

# Ativa o profile QA do Spring
ENV SPRING_PROFILES_ACTIVE=qa
ENV JAVA_OPTS="-Djdk.tls.client.protocols=TLSv1.2 -Dhttps.protocols=TLSv1.2 -Djavax.net.debug=ssl"

# Comando para iniciar a aplicação
ENTRYPOINT ["java","-jar","app.jar"]
