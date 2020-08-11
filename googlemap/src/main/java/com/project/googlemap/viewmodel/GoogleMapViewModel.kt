package com.project.googlemap.viewmodel

import androidx.lifecycle.LiveData
import com.project.content.base.BaseViewModel
import com.project.content.ext.SingleLiveEvent
import com.project.content.services.PermissionHelper
import io.reactivex.subjects.BehaviorSubject


open class GoogleMapViewModel(val permissionHelper: PermissionHelper) : BaseViewModel() {

    val onMoveMyLocationBehaviorSubject = BehaviorSubject.createDefault(true)

    private val _permissionCheckLiveData =
        SingleLiveEvent<Boolean>()

    val permissionCheckLiveData: LiveData<Boolean>
        get() = _permissionCheckLiveData

    fun onMoveCurrentLocationListener() {
        _permissionCheckLiveData.value = permissionHelper.isGrantLocationPermission()
    }
}