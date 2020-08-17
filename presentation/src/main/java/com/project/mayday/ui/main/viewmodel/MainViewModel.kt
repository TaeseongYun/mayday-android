package com.project.mayday.ui.main.viewmodel

import androidx.lifecycle.LiveData
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.project.content.ext.SingleLiveEvent
import com.project.content.services.PermissionHelper
import com.project.googlemap.MainGoogleMapFragment
import com.project.googlemap.viewmodel.GoogleMapViewModel

class MainViewModel(permissionHelper: PermissionHelper) : GoogleMapViewModel(permissionHelper) {
    init {
        getCurrentLocation = {

            // googleMap.myLocation -> 디플리케이트.
            val latLng = LatLng(
                googleMap.myLocation.latitude,
                googleMap.myLocation.longitude
            )

            googleMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(
                    latLng,
                    MainGoogleMapFragment.ZOOM_DEGREE
                )
            )
        }
    }

    private val _permissionCheckLiveData =
        SingleLiveEvent<Boolean>()

    val permissionCheckLiveData: LiveData<Boolean>
        get() = _permissionCheckLiveData

    fun onMoveCurrentLocationListener() {
        if(permissionHelper.isGrantLocationPermission()) {
            onMoveMyLocationBehaviorSubject.onNext(true)
        }
        _permissionCheckLiveData.value = permissionHelper.isGrantLocationPermission()
    }
}