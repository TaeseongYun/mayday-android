package com.project.googlemap.helper.gpstracker

import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.tasks.Task

interface GpsTracker {
    fun getFusedLocationProviderClient(): Task<Location>

    fun getCurrentLatitude(): Double

    fun getCurrentLongitude(): Double

    fun removeUsingGPS()
}