plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
//    id("com.google.gms.google-services")
}

android {
    compileSdkVersion(Apps.compileSdk)
    buildToolsVersion(Apps.buildToolVersion)

    defaultConfig {
        minSdkVersion(Apps.minSdk)
        targetSdkVersion(Apps.targetSdk)
        multiDexEnabled = true
        versionCode = Apps.versionCode
        versionName = Apps.versionName
        testInstrumentationRunner = Apps.testInstrumentationRunner
    }

    buildTypes {
        getByName(BuildTypes.DEBUG) {
            isDebuggable = true
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

        getByName(BuildTypes.RELEASE) {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = Apps.sourceCompatibility
        targetCompatibility = Apps.targetCompatibility
    }

    kotlinOptions {
        jvmTarget = Apps.jvmTarget
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    //Kotlin
    implementation(Libs.kotlin)
    //Standard
    implementation(Libs.appcompat)
    implementation(Libs.coreKtx)
    implementation(Libs.constraintLayout)
    implementation(Libs.recyclerview)

    //Retrofit
    implementation(Libs.retrofit2)
    implementation(Libs.converterGson)
    implementation(Libs.anko)
    implementation(Libs.adapterRxJava2)
    implementation(Libs.okHttp3)
    implementation(Libs.loggingInterceptor)

    //Rx
    implementation(Libs.rxAndroid)
    implementation(Libs.rxKotlin)

    //Image
    implementation(Libs.picasso)

    //Room
    implementation(Libs.roomRuntime)
    implementation(Libs.roomRxJava2)
    implementation(Libs.roomCompiler)

    //DI
    implementation(Libs.koinViewModel)

    //Firebase
    implementation(Libs.fbmessaging)
    implementation(Libs.fbcore)

    //MP
    implementation(Libs.logger)

    //Coroutine
    implementation(Libs.coroutinecore)
    implementation(Libs.coroutineandroid)

    //Test
    implementation(TestLibs.junit)
    implementation(TestLibs.junitExt)
    implementation(TestLibs.espresso)

    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":local"))
    implementation(project(":remote"))
    implementation(project(":content"))
}