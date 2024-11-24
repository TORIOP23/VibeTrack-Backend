FROM gradle:jdk21 AS builder
WORKDIR /builder
COPY build.gradle settings.gradle ./
RUN gradle build 2>/dev/null || true
COPY src ./src
RUN gradle build

FROM bellsoft/liberica-runtime-container:jre-21-cds-slim-musl AS base

FROM base AS optimizer
WORKDIR /builder
COPY --from=builder /builder/build/libs/*.jar identity.jar
RUN java -Djarmode=tools -jar identity.jar extract --layers --destination extracted

FROM base
EXPOSE 8080
RUN addgroup --system -g 1000 identity && adduser --system -u 1000 -G identity identity
WORKDIR /app
COPY --from=optimizer --chown=identity:identity /builder/extracted/dependencies/ ./
COPY --from=optimizer --chown=identity:identity /builder/extracted/spring-boot-loader/ ./
COPY --from=optimizer --chown=identity:identity /builder/extracted/snapshot-dependencies/ ./
COPY --from=optimizer --chown=identity:identity /builder/extracted/application/ ./

RUN java -XX:ArchiveClassesAtExit=application.jsa \
    -Dspring.jpa.hibernate.ddl-auto=none \
    -Dspring.sql.init.mode=never \
    -jar identity.jar

USER identity
ENTRYPOINT ["java", "-XX:SharedArchiveFile=application.jsa", "-jar", "identity.jar"]