package com.project.googlemap

import android.annotation.SuppressLint
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.project.googlemap.databinding.MainGoogleMapLayoutBinding
import com.project.googlemap.helper.AbstractGoogleMapHelper
import com.project.googlemap.viewmodel.GoogleMapViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener
import com.google.android.gms.maps.GoogleMap.OnMyLocationClickListener

class MainGoogleMapFragment :
    AbstractGoogleMapHelper<MainGoogleMapLayoutBinding, GoogleMapViewModel>(),
    OnMyLocationButtonClickListener, OnMyLocationClickListener,OnMapReadyCallback {

    override val viewModel: GoogleMapViewModel by viewModel()

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
////        bind {
////            lifecycleOwner = viewLifecycleOwner
////        }
//    }

    override fun onMapReady(customGoogleMaps: GoogleMap) {
        Log.e("onMapReady", "REady")
        googleMap = customGoogleMaps
        googleMapReady(onMapAsyncCallback)
    }

    @SuppressLint("MissingPermission")
    override fun googleMapReady(
        onMapAsyncCallback: (FragmentManager?) -> Unit
    ) {
        googleMap.mapType = GoogleMap.MAP_TYPE_NORMAL
        if (viewModel.permissionHelper.isGrantLocationPermission()) {
            googleMap.isMyLocationEnabled = true
        }
        Log.e("HI", "hji")
        googleMap.setOnMyLocationButtonClickListener(this)
        googleMap.setOnMyLocationClickListener(this)
        onMapAsyncCallback(activity?.supportFragmentManager)
//        (dataBinding.root.map_fragment as SupportMapFragment).getMapAsync(this)
    }

    override fun onMyLocationButtonClick(): Boolean {
        Toast.makeText(this.context, "MyLocation button clicked", Toast.LENGTH_SHORT).show()
        return false
    }

    override fun onMyLocationClick(location: Location) {
        Log.e("LOcation", location.toString())
    }
}