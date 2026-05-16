# ── Stage 1: Build ──────────────────────────────────────────────────────────
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copia o backend inteiro
COPY ecoTaggy-backend/ ./ecoTaggy-backend/

# Build sem testes (mais rápido no CI/CD)
RUN cd ecoTaggy-backend && mvn clean package -DskipTests

# ── Stage 2: Runtime ────────────────────────────────────────────────────────
FROM eclipse-temurin:21-jre


