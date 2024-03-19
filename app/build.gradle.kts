plugins {
    application

    jacoco
    id ("org.barfuin.gradle.jacocolog") version "3.1.0"

    id("com.diffplug.spotless") version "6.25.0"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation(libs.guava)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass.set("org.example.App")
}

tasks.jar {
    manifest.attributes["Main-Class"] = application.mainClass
    archiveBaseName.set("vacuum-agent")
}

/* Testing Configurations */

jacoco {
    toolVersion = "0.8.11"
}

tasks.named<Test>("test") {
    useJUnitPlatform()

    testLogging {
        events("passed", "skipped", "failed", "standardOut", "standardError")
    }

    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
}

/* Code Formatting */

spotless {
    java {
        importOrder()
        cleanthat()
        googleJavaFormat()
    }
}

tasks.check {
    dependsOn(tasks.spotlessCheck)
}

tasks.register("format") {
    dependsOn(tasks.spotlessApply)
}
