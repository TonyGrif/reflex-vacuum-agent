plugins {
    application

    jacoco
    id ("org.barfuin.gradle.jacocolog") version "3.1.0"

    id("com.diffplug.spotless") version "6.25.0"

    pmd
    checkstyle
    id("com.github.spotbugs") version "6.0.8"
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

/* Linting */

pmd {
    toolVersion = "6.55.0"
    isConsoleOutput = true
}

tasks.pmdTest {
    enabled = false
}

tasks.withType<Pmd>().configureEach {
    ignoreFailures = true
}

checkstyle {
    toolVersion = "10.14.2"
}

tasks.checkstyleTest {
    enabled = false
}

tasks.withType<Checkstyle>().configureEach {
    ignoreFailures = true
}

spotbugs {
    ignoreFailures = true
}
