FROM gradle:jdk21 AS builder
WORKDIR /builder
COPY build.gradle.kts settings.gradle.kts ./
COPY src ./src
RUN gradle build

FROM eclipse-temurin:21-jre-alpine
EXPOSE 8080
WORKDIR /app
RUN addgroup -g 1000 gateway  \
    && adduser -u 1000 -G gateway -D -H gateway
COPY --from=builder --chown=gateway:gateway /builder/build/libs/*.jar ./gateway.jar
USER gateway
ENTRYPOINT ["java","-jar","./gateway.jar"]