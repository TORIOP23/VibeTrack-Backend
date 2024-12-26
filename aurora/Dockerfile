FROM gradle:jdk21 AS builder
WORKDIR /builder
COPY build.gradle.kts settings.gradle.kts ./
COPY src ./src
RUN gradle build

FROM eclipse-temurin:21-jre-alpine
EXPOSE 9002
WORKDIR /app
RUN addgroup -g 1000 aurora  \
    && adduser -u 1000 -G aurora -D -H aurora
COPY --from=builder --chown=aurora:aurora /builder/build/libs/*.jar ./aurora.jar
USER aurora
ENTRYPOINT ["java","-jar","./aurora.jar"]