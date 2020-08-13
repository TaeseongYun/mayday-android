package com.project.mayday.ui.main.viewmodel

import android.location.Location
import android.util.Log
import androidx.lifecycle.LiveData
import com.project.content.ext.SingleLiveEvent
import com.project.content.services.PermissionHelper
import com.project.googlemap.viewmodel.GoogleMapViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.zipWith
import io.reactivex.schedulers.Schedulers

class MainViewModel(permissionHelper: PermissionHelper) : GoogleMapViewModel(permissionHelper) {

    private val _permissionCheckLiveData =
        SingleLiveEvent<Boolean>()

    val permissionCheckLiveData: LiveData<Boolean>
        get() = _permissionCheckLiveData

    fun onMoveCurrentLocationListener() {
        _permissionCheckLiveData.value = permissionHelper.isGrantLocationPermission()
    }
}