FROM gradle:jdk21 AS builder
WORKDIR /builder
COPY build.gradle settings.gradle ./
COPY src ./src
RUN gradle build

FROM eclipse-temurin:21-jre-alpine
EXPOSE 8080
WORKDIR /app
RUN addgroup -g 1000 identity  \
    && adduser -u 1000 -G identity -D -H identity
COPY --from=builder --chown=identity:identity /builder/build/libs/*.jar ./identity.jar
USER identity
ENTRYPOINT ["java","-jar","./identity.jar"]