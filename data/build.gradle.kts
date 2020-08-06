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

        buildTypes {
            getByName(BuildTypes.DEBUG) {
                // TODO : 아직은 초기작업이니 ConfigField 는 후에 추가 부탁드려요.
                isDebuggable = true
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
            getByName(BuildTypes.RELEASE) {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }
    }

    compileOptions {
        sourceCompatibility = Apps.sourceCompatibility
        targetCompatibility = Apps.targetCompatibility
    }

    sourceSets {
        getByName(SourceSets.MAIN).java.srcDir("src/main/kotlin")
        getByName(SourceSets.TEST).java.srcDir("src/test/kotlin")
    }

    kotlinOptions {
        jvmTarget = Apps.JVM_TARGET
    }
}

dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.KOTLIN)
    implementation(Libs.CORE_KTX)
    implementation(Libs.APP_COMPAT)

    // RxJava
    implementation(Libs.RX_ANDROID)
    implementation(Libs.RX_KOTLIN)

    // Retrofit, OkHttp, Gson
    implementation(Libs.RETROFIT2)
    implementation(Libs.OKHTTP3)
    implementation(Libs.LOGGING_INTERCEPTORS)
    implementation(Libs.CONVERTER_GSON)
    implementation(Libs.ADAPTER_RXJAVA2)
    implementation(Libs.GSON)

    //DI
    implementation(Libs.KOIN_VIEWMODEL)

    // Room  -> data는 필요 없을 것 같아서 일단 주석처리 하였습니다. 2020.08.04 by 배성재
//    implementation(Libs.ROOM_RUNTIME)
//    implementation(Libs.ROOM_KTX)
//    implementation(Libs.ROOM_RXJAVA2)
//    kapt(Libs.roomCompiler)

    // Logger
    implementation(Libs.LOGGER)

    //Test
    implementation(TestLibs.JUNIT)
    implementation(TestLibs.JUNIT_EXT)
    implementation(TestLibs.ESPRESSO)

    implementation(project(":domain"))
}
