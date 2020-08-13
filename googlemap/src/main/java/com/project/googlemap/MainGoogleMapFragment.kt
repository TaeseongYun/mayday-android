package com.project.googlemap

import android.annotation.SuppressLint
import android.location.Location
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.tasks.Task
import com.project.googlemap.helper.AbstractGoogleMapHelper
import com.project.googlemap.helper.gpstracker.GpsTracker
import com.project.googlemap.viewmodel.GoogleMapViewModel
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MainGoogleMapFragment :
    AbstractGoogleMapHelper<GoogleMapViewModel>() {

    override val viewModel: GoogleMapViewModel by viewModel()

    internal val gpsTracker by inject<GpsTracker>()

    @SuppressLint("MissingPermission")
    override fun googleMapReady(
        onMapAsyncCallback: (FragmentManager?) -> Unit
    ) {
        googleMap.mapType = GoogleMap.MAP_TYPE_NORMAL
        if (viewModel.permissionHelper.isGrantLocationPermission()) {
            val task = gpsTracker.getFusedLocationProviderClient()
            task.addOnSuccessListener {
                viewModel.onLocationPublishSubject.onNext(it)
//                Log.e("SUCCESS", "HI")
//                Log.e("LOCATION", it.latitude.toString())
            }
//            viewModel.onLocationPublishSubject.onNext(gpsTracker.getCurrentLocation() ?: return)
//            googleMap.isMyLocationEnabled = true
        }
//        googleMap.setOnMyLocationButtonClickListener {
//            Toast.makeText(this.context, "MyLocation button clicked", Toast.LENGTH_SHORT).show()
//            false
//        }

        googleMap.setOnCameraMoveListener {
            viewModel.onMoveMyLocationBehaviorSubject.onNext(false)
        }
//        googleMap.setOnMyLocationClickListener {
//            Log.e("LOcation", it.toString())
//        }

        onMapAsyncCallback(activity?.supportFragmentManager)
    }
}