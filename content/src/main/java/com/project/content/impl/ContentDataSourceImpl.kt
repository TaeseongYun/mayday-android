package com.project.content.impl

import android.annotation.SuppressLint
import android.app.Application
import android.content.pm.PackageInfo
import android.os.Build
import android.provider.Settings
import com.project.content.BuildConfig
import com.project.content.ContentDataSource
import java.util.*

@SuppressLint("HardwareIds")
class ContentDataSourceImpl(private val context: Application) : ContentDataSource {

    override fun getPackageInfo(): PackageInfo? = context.packageManager.getPackageInfo(context.packageName, 0)

    override fun getDeviceId(): String? = Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)

    override fun getRandomId() = UUID.randomUUID().toString()

    override fun getVersionName() = BuildConfig.VERSION_NAME

    override fun getVersionCode() = BuildConfig.VERSION_CODE

    override fun getSDKVersion() = Build.VERSION.SDK_INT.toString()
}