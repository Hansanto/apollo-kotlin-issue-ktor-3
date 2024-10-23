plugins {
    kotlin("jvm") version "2.0.21"
}

group = "test"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.apollographql.ktor:apollo-engine-ktor:0.0.2")
//    implementation("io.ktor:ktor-client-core-jvm:2.3.12")
    implementation("io.ktor:ktor-client-core-jvm:3.0.0")
}

tasks.test {
    useJUnitPlatform()
}
