plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Apps.compileSdk)
    buildToolsVersion(Apps.buildToolVersion)

    defaultConfig {
        minSdkVersion(Apps.minSdk)
        targetSdkVersion(Apps.targetSdk)
        versionCode = Apps.versionCode
        versionName = Apps.versionName

        buildTypes {
            getByName(BuildTypes.DEBUG) {
//                buildConfigField("String", "BASE_URL", "\"https://kinicarevip.xyz/kinivip/\"")
            }
            getByName(BuildTypes.RELEASE) {
//                buildConfigField("String", "BASE_URL", "\"https://kinicarevip.xyz/kinivip/\"")
            }
        }
    }

    buildTypes {
        getByName(BuildTypes.RELEASE) {
            isMinifyEnabled = false
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
        jvmTarget = Apps.jvmTarget
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.kotlin)
    implementation(Libs.coreKtx)
    implementation(Libs.appcompat)

    // RxJava
    implementation(Libs.rxJava2)
    implementation(Libs.rxAndroid)
    implementation(Libs.rxKotlin)

    // Retrofit, OkHttp, Gson
    implementation(Libs.retrofit2)
    implementation(Libs.okHttp3)
    implementation(Libs.loggingInterceptor)
    implementation(Libs.converterGson)
    implementation(Libs.adapterRxJava2)
    implementation(Libs.gson)

    //DI
    implementation(Libs.koinViewModel)

    // Logger
    implementation(Libs.logger)

    //Test
    implementation(TestLibs.junit)
    implementation(TestLibs.junitExt)
    implementation(TestLibs.espresso)

    implementation(project(":data"))
}
