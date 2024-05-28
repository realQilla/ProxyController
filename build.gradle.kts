plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("org.jetbrains.gradle.plugin.idea-ext") version "1.1.8"
}

group = "net.qilla"
version = "0.0.1"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
}

configurations.create("shade")

dependencies {
    implementation("com.velocitypowered:velocity-api:3.3.0-SNAPSHOT")
    annotationProcessor("com.velocitypowered:velocity-api:3.3.0-SNAPSHOT")
    "shade"("com.mysql:mysql-connector-j:8.0.33")
}


tasks {
    build {
        dependsOn("shadowJar")
    }

    withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.release.set(17)
    }

    withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
        configurations = listOf(project.configurations.getByName("shade"))
        destinationDirectory.set(file("C:\\Users\\Richard\\Development\\Servers\\Servers Proxy\\Velocity Proxy\\plugins"))
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}