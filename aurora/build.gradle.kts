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
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {
    implementation(libs.actuator)
    implementation(libs.jpa)
    implementation(libs.validation)
    implementation(libs.web)

    implementation(libs.mapstruct)
    annotationProcessor(libs.mapstructProcessor)
    annotationProcessor(libs.lombokMapstructBinding)

    implementation(libs.springdoc)

    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)

    runtimeOnly("com.mysql:mysql-connector-j")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

