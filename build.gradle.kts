buildscript {
    repositories {
        google()
        jcenter()

        dependencies {
            classpath("com.android.tools.build:gradle:${Versions.gradle}")
            classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
            classpath("com.google.gms:google-services:${Versions.googleservice}")
            classpath("com.android.tools.build:gradle:${Versions.gradle}")
        }
    }

    allprojects {
        repositories {
            google()
            jcenter()
            maven { url = uri("https://maven.google.com/") }
            maven { url = uri("https://jitpack.io") }
        }
    }

    tasks.register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
}