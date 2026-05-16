# ── Stage 1: Build ──────────────────────────────────────────────────────────
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copia o backend inteiro
COPY ecoTaggy-backend/ ./ecoTaggy-backend/

# Build sem testes (mais rápido no CI/CD)
RUN cd ecoTaggy-backend && mvn clean package -DskipTests

# ── Stage 2: Runtime ────────────────────────────────────────────────────────
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copia apenas o JAR gerado
COPY --from=build /app/ecoTaggy-backend/target/ecoTaggy-backend-0.0.1-SNAPSHOT.jar app.jar

# Porta que o Railway vai usar (variável de ambiente PORT)
EXPOSE 8080

# Inicia a aplicação respeitando a variável PORT do Railway
ENTRYPOINT ["java", "-jar", "app.jar"]
