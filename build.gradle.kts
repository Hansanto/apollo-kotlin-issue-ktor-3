plugins {
    kotlin("jvm") version "2.0.21"
}

group = "test"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.apollographql.apollo3:apollo-engine-ktor:4.0.0-beta.7")
//    implementation("io.ktor:ktor-client-core-jvm:2.3.12")
    implementation("io.ktor:ktor-client-core-jvm:3.0.0")
}

tasks.test {
    useJUnitPlatform()
}
