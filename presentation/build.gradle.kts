plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    id("kotlin-android")
}

android {
    compileSdkVersion(Apps.COMPILE_SDK)
    buildToolsVersion(Apps.BUILD_TOOL_VERSION)

    defaultConfig {
        applicationId = Apps.ID
        minSdkVersion(Apps.MIN_SDK)
        targetSdkVersion(Apps.TARGET_SDK)
        versionCode = Apps.VERSION_CODE
        versionName = Apps.VERSION_NAME
        testInstrumentationRunner = Apps.TEST_INSTRUMENTATION_RUNNER
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
        jvmTarget = Apps.JVM_TARGET
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
    api(Libs.MATERIAL)
    /***
     * Material 에 보시면 카드뷰와 리사이클러뷰가 포함되어 있습니다.
     *
     * 참고 url : https://mvnrepository.com/artifact/com.google.android.material/material/1.3.0-alpha01
     * 2020. 08. 10 윤태성
     ***/
    implementation(Libs.CONSTRAINT_LAYOUT)

    //Retrofit
    implementation(Libs.RETROFIT2)
    implementation(Libs.CONVERTER_GSON)
    implementation(Libs.ANKO)
    implementation(Libs.ADAPTER_RXJAVA2)
    implementation(Libs.OKHTTP3)
    implementation(Libs.LOGGING_INTERCEPTORS)

    //Rx
    implementation(Libs.RX_ANDROID)
    implementation(Libs.RX_KOTLIN)

    //Image
    implementation(Libs.PICASSO)

    // Room  -> data는 필요 없을 것 같아서 일단 주석처리 하였습니다. 2020.08.04 by 배성재
//    implementation(Libs.roomRuntime)
//    implementation(Libs.roomRxJava2)
//    implementation(Libs.roomCompiler)

    //DI
    implementation(Libs.KOIN_VIEWMODEL)

    //Firebase
    implementation(Libs.FIREBASE_MESSAGING)
    implementation(Libs.FIREBASE_CORE)

    //MP
    implementation(Libs.LOGGER)

    //Coroutine
    implementation(Libs.COROUTINE_CORE)
    implementation(Libs.COROUTINE_ANDROID)

    //Test
    implementation(TestLibs.JUNIT)
    implementation(TestLibs.JUNIT_EXT)
    implementation(TestLibs.ESPRESSO)
    implementation(Libs.GOOGLE_MAPS)
    implementation(Libs.GOOGLE_LOCATION)
    implementation(Libs.FIREBASE_ANALYTICS)
    implementation(Libs.FIREBASE_CRASHLYTICS)

    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":local"))
    implementation(project(":remote"))
    implementation(project(":content"))
    implementation(project(":googlemap"))
}