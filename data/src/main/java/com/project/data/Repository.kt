package com.project.data

import android.content.pm.PackageInfo

interface Repository {

    fun getString(key: String): String?
    fun getInt(key: String): Int
    fun getLong(key: String): Long
    fun getBoolean(key: String): Boolean

    fun putBoolean(key: String, data: Boolean)
    fun putString(key: String, data: String)
    fun putInt(key: String, data: Int)
    fun putLong(key: String, data: Long)

    fun clearData()

    fun getPackageInfo(): PackageInfo?
    fun getVersionName(): String
    fun getVersionCode(): Int
    fun getDeviceId(): String?
    fun getRandomId(): String?
    fun getSDKVersion(): String
}