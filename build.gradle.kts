import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21" apply false
    id("com.google.protobuf") version "0.8.18" apply false

    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"
}

ext["grpcVersion"] = "1.46.0"
ext["protobufVersion"] = "3.20.1"
ext["grpcKotlinVersion"] = "1.3.0"
ext["coroutinesVersion"] = "1.6.2"

subprojects {

    apply {
        plugin("java")
        plugin("org.jetbrains.kotlin.jvm")
    }

    // gradle-nexus/publish-plugin needs these here too
    group = rootProject.group
    version = rootProject.version

    repositories {
        mavenCentral()
    }

    tasks.withType<JavaCompile> {
        sourceCompatibility = JavaVersion.VERSION_1_8.toString()
        targetCompatibility = JavaVersion.VERSION_1_8.toString()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }
}
