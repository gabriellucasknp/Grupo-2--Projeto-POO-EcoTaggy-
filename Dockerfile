# ── Stage 1: Build ──────────────────────────────────────────────────────────
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

COPY ecoTaggy-backend/ ./ecoTaggy-backend/

RUN chmod +x ./ecoTaggy-backend/mvnw \
    && cd ./ecoTaggy-backend \
    && ./mvnw clean package -DskipTests

# ── Stage 2: Runtime ────────────────────────────────────────────────────────
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/ecoTaggy-backend/target/ecoTaggy-backend-*.jar ./app.jar

EXPOSE 8080

CMD ["sh", "-c", "java -Dserver.port=${PORT:-8080} -jar /app/app.jar"]
