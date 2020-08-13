package com.project.googlemap.helper

import androidx.fragment.app.FragmentManager
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment

interface GoogleMapHelper {
    var googleMap: GoogleMap

    fun googleMapReady(onMapAsyncCallback: (FragmentManager?) -> Unit)
}