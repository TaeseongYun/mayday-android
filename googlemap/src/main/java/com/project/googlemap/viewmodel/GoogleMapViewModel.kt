package com.project.googlemap.viewmodel

import android.location.Location
import com.project.content.base.BaseViewModel
import com.project.content.services.PermissionHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.zipWith
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject


open class GoogleMapViewModel(val permissionHelper: PermissionHelper) : BaseViewModel() {

    val onMoveMyLocationBehaviorSubject = BehaviorSubject.createDefault(true)

    val onLocationPublishSubject = BehaviorSubject.create<Location>()

    init {
        onMoveMyLocationBehaviorSubject
            .subscribeOn(Schedulers.single())
            .observeOn(AndroidSchedulers.mainThread())
            .zipWith(onLocationPublishSubject)
            .onErrorReturn {
                Pair(false, onLocationPublishSubject.blockingFirst())
            }
            .subscribe { isCameraMoved ->
                if (isCameraMoved.first && ::getCurrentLocation.isInitialized) {
                    getCurrentLocation(isCameraMoved.second)
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


    lateinit var setOnDefaultLocation: (Location) -> Unit
    lateinit var getCurrentLocation: (Location) -> Unit
}