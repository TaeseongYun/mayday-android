package com.project.googlemap.viewmodel

import android.location.Location
import com.google.android.gms.maps.GoogleMap
import com.project.content.base.BaseViewModel
import com.project.content.services.PermissionHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject


open class GoogleMapViewModel(val permissionHelper: PermissionHelper) : BaseViewModel() {

    lateinit var googleMap: GoogleMap

    val onMoveMyLocationBehaviorSubject = BehaviorSubject.create<Boolean>()

    val onLocationPublishSubject = BehaviorSubject.create<Location>()

    init {
        onMoveMyLocationBehaviorSubject
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .onErrorReturn {
                false
            }
            .filter { it }
            .subscribe { isCameraMoved ->
                if (isCameraMoved && ::getCurrentLocation.isInitialized) {
                    getCurrentLocation()
                }
            }
            .addDisposable()

        onLocationPublishSubject
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .onErrorReturn {
                //blockingFirst() -> ?
                onLocationPublishSubject.blockingFirst()
            }
            .subscribe {
                if (::setOnDefaultLocation.isInitialized) {
                    setOnDefaultLocation(it)
                }
            }
            .addDisposable()
    }


    lateinit var getCurrentLocation: () -> Unit
    lateinit var setOnDefaultLocation: (Location) -> Unit
}