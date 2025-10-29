# =============================
# Etapa 1: Build com Maven + JDK 21
# =============================
FROM maven:3.9.4-eclipse-temurin-21 AS builder

# Diretório de trabalho
WORKDIR /app

# Copia APENAS o pom.xml primeiro (melhora cache do Docker)
COPY pom.xml .

# Baixa dependências primeiro (cache eficiente)
RUN mvn dependency:go-offline -DskipTests

# Copia o código fonte
COPY src ./src

# Build do projeto com retry em caso de falha de download
RUN mvn clean package -DskipTests \
    -Dmaven.wagon.http.retryHandler.count=3 \
    -Dmaven.wagon.httpconnectionManager.ttlSeconds=25

# =============================
# Etapa 2: Runtime com JDK 21 slim
# =============================
FROM openjdk:21-jdk-slim

WORKDIR /app

# Copia o JAR gerado na etapa de build
COPY --from=builder /app/target/*.jar app.jar

# Cria usuário não-root para segurança
RUN groupadd -r spring && useradd -r -g spring spring
USER spring

# Porta que a API vai escutar
EXPOSE 27100

# Ativa o profile QA do Spring
ENV SPRING_PROFILES_ACTIVE=qa

# Otimizações JVM para containers
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

# Comando para iniciar a aplicação
ENTRYPOINT ["java","-jar","app.jar"]