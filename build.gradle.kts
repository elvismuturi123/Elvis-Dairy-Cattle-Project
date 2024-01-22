buildscript {
    repositories {
        google()  // Google's Maven repository
        mavenCentral()
        maven {
            url = uri("https://jitpack.io")
        }
    }
    dependencies {
        classpath("com.google.gms:google-services:4.4.0")
        // classpath("io.realm:realm-gradle-plugin:3.2.1")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.2" apply false
}