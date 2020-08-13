package com.project.googlemap.helper.gpstracker

import android.content.Context
import android.location.Location

interface GpsTracker {
    fun getLocation(): Location

    fun getLatitude(): Double

    fun getLongitude(): Double
}