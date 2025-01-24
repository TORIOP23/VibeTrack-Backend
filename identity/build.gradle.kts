plugins {
    java
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependencies)
}

group = "com.vibetrack"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {
    implementation(libs.jpa)
    implementation(libs.web)
    implementation(libs.validation)
    implementation(libs.actuator)

    implementation(libs.mapstruct)
    annotationProcessor(libs.mapstructProcessor)
    annotationProcessor(libs.lombokMapstructBinding)

    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")

    implementation(libs.springdoc)
    // https://mvnrepository.com/artifact/io.swagger.core.v3/swagger-annotations
    implementation("io.swagger.core.v3:swagger-annotations:2.2.26")

    runtimeOnly("com.mysql:mysql-connector-j")

    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)

    developmentOnly("org.springframework.boot:spring-boot-devtools")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

