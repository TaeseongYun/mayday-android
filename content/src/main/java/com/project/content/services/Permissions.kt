package com.project.content.services

import android.Manifest

object Permissions {
    const val REQUEST_LOCATION_PERMISSIONS = 2000

    const val GPS_REQUEST_CODE = 2001

    val REQUEST_PERMISSIONS =
        listOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)
}