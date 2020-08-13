package com.project.googlemap.helper.gpstracker

import android.annotation.SuppressLint
import android.app.Service
import android.content.Context
import android.content.Intent
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.Task
import com.project.content.ext.toast
import com.project.googlemap.R
import java.lang.Exception

internal class GpsTrackerImpl(private val context: Context) : GpsTracker, Service(),
    LocationListener {

    lateinit var client: FusedLocationProviderClient
    lateinit var locationManager: LocationManager
    var location: Location? = null
    var latitude: Double? = null
    var longitude: Double? = null
    private val MIN_TIME_BW_UPDATES = 10L
    private val MIN_DISTANCE_CHANGE_FOR_UPDATES: Float = (1000 * 60 * 1).toFloat()

    @SuppressLint("MissingPermission")
    override fun getFusedLocationProviderClient(): Task<Location> {
        try {
            client = LocationServices.getFusedLocationProviderClient(context)
//            Task<Location>
//            locationManager =
//                (context.getSystemService(Context.LOCATION_SERVICE) as LocationManager)
//
//            val isGpsEnable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
//            val isNetworkEnabled =
//                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
//
//            if (!isGpsEnable && !isNetworkEnabled) {
//                context.toast(getString(R.string.check_gps), Toast.LENGTH_LONG)
//            } else {
//                locationManager.requestLocationUpdates(
//                    LocationManager.NETWORK_PROVIDER,
//                    MIN_TIME_BW_UPDATES,
//                    MIN_DISTANCE_CHANGE_FOR_UPDATES,
//                    this
//                )
//
//                location =
//                    locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
//                location?.let {
//                    latitude = it.latitude
//                    longitude = it.longitude
//                }
//
//            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        Log.e("LOCATION", client.toString())
        return client.lastLocation
    }

    override fun getCurrentLatitude(): Double {
        return location?.latitude ?: UNKNOWN_LOCATE
    }

    override fun getCurrentLongitude(): Double {
        return location?.longitude ?: UNKNOWN_LOCATE
    }

    override fun removeUsingGPS() {
        locationManager.removeUpdates(this)
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onLocationChanged(p0: Location?) {

    }

    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
    }

    override fun onProviderEnabled(p0: String?) {
    }

    override fun onProviderDisabled(p0: String?) {
    }


    companion object {
        private const val UNKNOWN_LOCATE: Double = 0.0
    }
}