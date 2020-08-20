package com.project.mayday.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.project.content.ext.SingleLiveEvent
import com.project.content.services.PermissionHelper
import com.project.domain.usecase.base.BaseUseCase
import com.project.googlemap.MainGoogleMapFragment
import com.project.googlemap.viewmodel.GoogleMapViewModel
import io.reactivex.android.schedulers.AndroidSchedulers

class MainViewModel(
    permissionHelper: PermissionHelper,
    baseUseCase: BaseUseCase<Boolean>
) : GoogleMapViewModel(permissionHelper, baseUseCase) {
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

        baseUseCase(false, AndroidSchedulers.mainThread(), {

            //doAfterTerminate
        }, { isCameraMoved ->
            if (isCameraMoved) {
                getCurrentLocation()
            }
        })

    }

    private val _permissionCheckLiveData =
        SingleLiveEvent<Boolean>()

    val permissionCheckLiveData: LiveData<Boolean>
        get() = _permissionCheckLiveData

    fun onMoveCurrentLocationListener() {
        Log.e("Click", System.currentTimeMillis().toString())
        if (permissionHelper.isGrantLocationPermission()) {
            baseUseCase(true, AndroidSchedulers.mainThread(), {

            }, { isCameraMoved ->
                if (isCameraMoved) {
                    getCurrentLocation()
                }
            })
        }
        _permissionCheckLiveData.value = permissionHelper.isGrantLocationPermission()
    }
}