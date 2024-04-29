plugins {
    id("java")
    id("application")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    mainClass = "erni.example.jfr.brackets.Main"
}

tasks.register<JavaExec>("runJfrProfilingConfig") {
    group = ApplicationPlugin.APPLICATION_GROUP
    mainClass = application.mainClass
    classpath = sourceSets.main.get().runtimeClasspath
    jvmArgs = listOf("-XX:StartFlightRecording=dumponexit=true,settings=profile,filename=profile.jfr")
}

tasks.register<JavaExec>("runJfrContinuousConfig") {
    group = ApplicationPlugin.APPLICATION_GROUP
    mainClass = application.mainClass
    classpath = sourceSets.main.get().runtimeClasspath
    jvmArgs = listOf("-XX:StartFlightRecording=dumponexit=true,settings=default,filename=default.jfr")
}

tasks.test {
    useJUnitPlatform()
}