package com.project.googlemap

import android.annotation.SuppressLint
import android.location.Location
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
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

        //TODO onCreate 시 현재위치로 바로 카메라 이동.
        viewModel.setOnDefaultLocation = {
            val latLng = LatLng(it.latitude, it.longitude)

            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, ZOOM_DEGREE))
        }

        //TODO 유저가 현재위치 버튼 클릭 시 해당 위치로 포커스 이동.


        if (viewModel.permissionHelper.isGrantLocationPermission()) {
            getCurrentLocation().also {
                it.addOnSuccessListener { location ->
                    viewModel.onLocationPublishSubject.onNext(location)
                }
            }
        }

        //현재 내 위치 UI 세팅
        googleMap.isMyLocationEnabled = true

        //디폴트 현재 내위치 UI 버튼 설정 해제.
        googleMap.uiSettings.isMyLocationButtonEnabled = false

        googleMap.setOnCameraMoveListener {
            viewModel.onMoveMyLocationBehaviorSubject.onNext(false)
        }


        onMapAsyncCallback(activity?.supportFragmentManager)
    }

    companion object {
        const val ZOOM_DEGREE = 16f
    }

    private fun getCurrentLocation(): Task<Location> {
        val task = gpsTracker.getFusedLocationProviderClient()
        return task
    }
}