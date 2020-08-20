package com.project.googlemap.viewmodel

import android.location.Location
import com.google.android.gms.maps.GoogleMap
import com.project.content.base.BaseViewModel
import com.project.content.services.PermissionHelper
import com.project.domain.usecase.base.BaseUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject


open class GoogleMapViewModel(
    val permissionHelper: PermissionHelper,
    val baseUseCase: BaseUseCase<Boolean>
) : BaseViewModel() {

    lateinit var googleMap: GoogleMap

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
                if (::setOnDefaultLocation.isInitialized) {
                    setOnDefaultLocation(it)
                }
            }
            .addDisposable()
    }


    lateinit var getCurrentLocation: () -> Unit
    lateinit var setOnDefaultLocation: (Location) -> Unit
}