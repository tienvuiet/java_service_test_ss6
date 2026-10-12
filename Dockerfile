FROM eclipse-temurin:21-jdk AS build

WORKDIR /workspace

COPY gradlew .
COPY gradle ./gradle
COPY build.gradle settings.gradle ./
COPY src ./src

RUN sed -i 's/\r$//' gradlew \
    && chmod +x gradlew \
    && ./gradlew bootJar --no-daemon -x test \
    && cp build/libs/*.jar /app.jar


FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

RUN apt-get update \
    && apt-get install -y --no-install-recommends curl \
    && rm -rf /var/lib/apt/lists/* \
    && useradd --system --uid 10001 appuser

COPY --from=build /app.jar /app/app.jar

USER appuser

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]