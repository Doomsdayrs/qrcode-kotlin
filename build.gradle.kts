buildscript {
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.20")
    }
}

repositories {
    mavenCentral()
    gradlePluginPortal()
    google()
}

plugins {
    // Base Plugins
    kotlin("multiplatform") version "1.6.20"
    id("com.android.library") version "7.1.3"

    // Publishing Plugins
    signing
    `maven-publish`
}

group = "io.github.g0dkar"
version = "3.1.1b"

kotlin {
    android {
        publishLibraryVariants("release")

        dependencies {
            implementation("com.android.tools.lint:lint-gradle:30.1.3")
        }
    }

    sourceSets {
        val commonTest by getting {
            dependencies {
                implementation("io.kotest:kotest-assertions-core:5.1.0")
                implementation("org.junit.jupiter:junit-jupiter:5.7.0")
                implementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
                implementation("org.junit.jupiter:junit-jupiter-engine:5.7.0")
            }
        }
        val androidMain by getting
        val androidTest by getting
    }
}

android {
    compileSdkVersion(31)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(31)
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
