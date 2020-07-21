package com.project.data.impl

import android.content.pm.PackageInfo
import com.project.data.LocalDataSource
import com.project.data.RemoteDataSource
import com.project.data.Repository

class RepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : Repository {
    override fun getString(key: String): String? {
        TODO("Not yet implemented")
    }

    override fun getInt(key: String): Int {
        TODO("Not yet implemented")
    }

    override fun getLong(key: String): Long {
        TODO("Not yet implemented")
    }

    override fun getBoolean(key: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun putBoolean(key: String, data: Boolean) {
        TODO("Not yet implemented")
    }

    override fun putString(key: String, data: String) {
        TODO("Not yet implemented")
    }

    override fun putInt(key: String, data: Int) {
        TODO("Not yet implemented")
    }

    override fun putLong(key: String, data: Long) {
        TODO("Not yet implemented")
    }

    override fun clearData() {
        TODO("Not yet implemented")
    }

    override fun getPackageInfo(): PackageInfo? {
        TODO("Not yet implemented")
    }

    override fun getVersionName(): String {
        TODO("Not yet implemented")
    }

    override fun getVersionCode(): Int {
        TODO("Not yet implemented")
    }

    override fun getDeviceId(): String? {
        TODO("Not yet implemented")
    }

    override fun getRandomId(): String? {
        TODO("Not yet implemented")
    }

    override fun getSDKVersion(): String {
        TODO("Not yet implemented")
    }


}