plugins {
    kotlin("jvm") version "1.4.32"
}

group = "by.danilov"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation(group = "org.springframework.boot", name = "spring-boot-starter", version = "2.5.1")
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-web", version = "2.5.1")

    implementation(group = "com.fasterxml.jackson.core", name = "jackson-databind", version = "2.12.4")
    implementation(group = "com.fasterxml.jackson.core", name = "jackson-core", version = "2.12.4")
    implementation(group = "com.fasterxml.jackson.module", name = "jackson-module-kotlin", version = "2.12.4")

    testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Test> {
    useJUnitPlatform()
}
