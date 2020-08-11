package com.project.mayday.ui.main.viewmodel

import com.project.content.services.PermissionHelper
import com.project.googlemap.viewmodel.GoogleMapViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(permissionHelper: PermissionHelper) : GoogleMapViewModel(permissionHelper) {

    init {
        onMoveMyLocationBehaviorSubject
            .subscribeOn(Schedulers.single())
            .observeOn(AndroidSchedulers.mainThread())
            .onErrorReturn {
                false
            }
            .subscribe { isCameraMoved ->
                if (isCameraMoved && ::getCurrentLocation.isInitialized) {
                    getCurrentLocation()
                }
            }
            .addDisposable()
    }

    lateinit var getCurrentLocation: () -> Unit
}