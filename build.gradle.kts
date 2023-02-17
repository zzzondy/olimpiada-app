buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        classpath(Dependencies.Serialization.kotlinSerialization)
        classpath(Dependencies.Hilt.daggerHiltProject)
    }
}

allprojects {
    repositories {
        mavenCentral()
    }
}

plugins {
    id(Plugins.androidApplication) version Plugins.androidApplicationVersion apply false
    id(Plugins.androidLibrary) version Plugins.androidLibraryVersion apply false
    id(Plugins.kotlinAndroid) version Plugins.kotlinAndroidVersion apply false
}