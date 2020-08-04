plugins {
    `java-library`
    id("kotlin")
}
dependencies {
    implementation(Libs.kotlin)
    implementation(Libs.coreKtx)
    implementation(Libs.appcompat)

    implementation(Libs.rxAndroid)
    implementation(Libs.rxKotlin)

    implementation(Libs.converterGson)
}