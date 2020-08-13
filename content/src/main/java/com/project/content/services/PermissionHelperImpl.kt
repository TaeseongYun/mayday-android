package com.project.content.services

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager.PERMISSION_DENIED
import androidx.core.content.ContextCompat

internal class PermissionHelperImpl(private val context: Context) : PermissionHelper {
    override fun isGrantLocationPermission(): Boolean {
        // gps 현재 장소 퍼미션.
        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PERMISSION_DENIED
        ) {
            return false
        }
        // gps 추적 퍼미션
        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PERMISSION_DENIED
        ) {
            return false
        }
        return true
    }
}