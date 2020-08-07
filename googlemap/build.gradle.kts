plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Apps.COMPILE_SDK)
    buildToolsVersion(Apps.BUILD_TOOL_VERSION)

    defaultConfig {
        minSdkVersion(Apps.MIN_SDK)
        targetSdkVersion(Apps.TARGET_SDK)
        versionCode = Apps.VERSION_CODE
        versionName = Apps.VERSION_NAME

        testInstrumentationRunner = Apps.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    //Kotlin
    implementation(Libs.KOTLIN)
    //Standard
    implementation(Libs.APP_COMPAT)
    implementation(Libs.CORE_KTX)

    //test
    implementation(TestLibs.JUNIT)
    implementation(TestLibs.JUNIT_EXT)
    implementation(TestLibs.ESPRESSO)

    //google map
    implementation(Libs.GOOGLE_MAPS)
    implementation(Libs.GOOGLE_LOCATION)

    //DI
    implementation(Libs.KOIN_VIEWMODEL)
}