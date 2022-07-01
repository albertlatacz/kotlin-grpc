plugins {
    application
    kotlin("jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(project(":protos"))
    implementation("io.grpc:grpc-netty:${rootProject.ext["grpcVersion"]}")
}
