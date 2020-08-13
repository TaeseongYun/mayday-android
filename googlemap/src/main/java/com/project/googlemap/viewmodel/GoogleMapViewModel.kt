package com.project.googlemap.viewmodel

import android.location.Location
import android.util.Log
import com.project.content.base.BaseViewModel
import com.project.content.services.PermissionHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject


open class GoogleMapViewModel(val permissionHelper: PermissionHelper) : BaseViewModel() {

    val onMoveMyLocationBehaviorSubject = BehaviorSubject.createDefault(true)

    val onLocationPublishSubject = BehaviorSubject.create<Location>()

    init {
        onLocationPublishSubject
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .onErrorReturn {
                //blockingFirst() -> ?
                onLocationPublishSubject.blockingFirst()
            }
            .subscribe {
                Log.i("LOCATION VIEWMODEL", it.latitude.toString())
                if (::setOnDefaultLocation.isInitialized) {
                    setOnDefaultLocation(it)
                }
            }
            .addDisposable()
    }


    lateinit var setOnDefaultLocation: (Location) -> Unit
    lateinit var getCurrentLocation: (Location) -> Unit
}