package com.project.googlemap.helper

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment

abstract class AbstractGoogleMapHelper<VM : ViewModel> :
    GoogleMapHelper, SupportMapFragment() {
    override lateinit var googleMap: GoogleMap

    abstract val viewModel: VM

    lateinit var onMapAsyncCallback: (FragmentManager?) -> Unit
}