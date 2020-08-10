package com.project.googlemap.viewmodel

import androidx.lifecycle.LiveData
import com.project.content.base.BaseViewModel
import com.project.content.ext.SingleLiveEvent
import com.project.content.services.PermissionHelper


open class GoogleMapViewModel(val permissionHelper: PermissionHelper) : BaseViewModel() {

    private val _permissionCheckLiveData =
        SingleLiveEvent<Boolean>()

    val permissionCheckLiveData: LiveData<Boolean>
        get() = _permissionCheckLiveData

    fun onMoveCurrentLocationListener() {
        _permissionCheckLiveData.value = permissionHelper.isGrantLocationPermission()
    }
}