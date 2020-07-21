package com.project.content

import android.content.pm.PackageInfo

interface ContentDataSource {

    fun getPackageInfo(): PackageInfo?
    fun getVersionName(): String
    fun getVersionCode(): Int
    fun getDeviceId(): String?
    fun getRandomId(): String
    fun getSDKVersion(): String
}