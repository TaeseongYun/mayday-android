package com.project.googlemap

import android.annotation.SuppressLint
import android.location.Location
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.google.android.gms.maps.GoogleMap
import com.project.googlemap.databinding.MainGoogleMapLayoutBinding
import com.project.googlemap.helper.AbstractGoogleMapHelper
import com.project.googlemap.viewmodel.GoogleMapViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener
import com.google.android.gms.maps.GoogleMap.OnMyLocationClickListener

class MainGoogleMapFragment :
    AbstractGoogleMapHelper<GoogleMapViewModel>(),
    OnMyLocationButtonClickListener, OnMyLocationClickListener {

    override val viewModel: GoogleMapViewModel by viewModel()

    @SuppressLint("MissingPermission")
    override fun googleMapReady(
        onMapAsyncCallback: (FragmentManager?) -> Unit
    ) {
        googleMap.mapType = GoogleMap.MAP_TYPE_NORMAL
        if (viewModel.permissionHelper.isGrantLocationPermission()) {
            googleMap.isMyLocationEnabled = true
        }
        googleMap.setOnMyLocationButtonClickListener(this)
        googleMap.setOnMyLocationClickListener(this)
        onMapAsyncCallback(activity?.supportFragmentManager)
    }

    override fun onMyLocationButtonClick(): Boolean {
        Toast.makeText(this.context, "MyLocation button clicked", Toast.LENGTH_SHORT).show()
        return false
    }

    override fun onMyLocationClick(location: Location) {
        Log.e("LOcation", location.toString())
    }
}