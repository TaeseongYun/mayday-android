package com.project.mayday.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.project.content.services.Permissions.REQUEST_LOCATION_PERMISSIONS
import com.project.content.services.Permissions.REQUEST_PERMISSIONS
import com.project.googlemap.MainGoogleMapFragment
import com.project.mayday.R
import com.project.mayday.base.BaseActivity
import com.project.mayday.databinding.ActivityMainBindingImpl
import com.project.mayday.ext.toast
import com.project.mayday.ui.main.bottomsheet.CustomBottomSheet
import com.project.mayday.ui.main.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class MainActivity : BaseActivity<ActivityMainBindingImpl, MainViewModel>(R.layout.activity_main),
    GoogleMap.OnMyLocationButtonClickListener, OnMapReadyCallback {

    override val vm: MainViewModel by viewModel()

    private val customBottomSheet by inject<CustomBottomSheet> {
        parametersOf(vm, supportFragmentManager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind {
            bottomSheet = customBottomSheet
            bookMarkLayout = R.layout.mayday_saved_bottom_sheet_layout
            storyLayout = R.layout.mayday_story_bottom_sheet_layout
            executePendingBindings()
        }

        (main_map_fragment as MainGoogleMapFragment).getMapAsync(this)

        (main_map_fragment as MainGoogleMapFragment).run {
            onMapAsyncCallback = {
                it?.findFragmentById(R.id.main_map_fragment)
            }
        }
        vm.getCurrentLocation = {
            /* 현재 위치로 이동 코드 작성.*/
        }

        vm.permissionCheckLiveData.observe(this, Observer<Boolean> { isGranted ->
            if (!isGranted) {
                requestPermissions(REQUEST_PERMISSIONS.toTypedArray(), REQUEST_LOCATION_PERMISSIONS)
            } else {

                vm.onMoveMyLocationBehaviorSubject.onNext(true)
            }
        })
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_LOCATION_PERMISSIONS && permissions.size == REQUEST_PERMISSIONS.size) {
            if (shouldShowRequestPermissionRationale(permissions[0]) || shouldShowRequestPermissionRationale(
                    permissions[1]
                )
            ) {
                toast(getString(R.string.denied_permission_alert_message), Toast.LENGTH_LONG)
            }
        }
    }

    override fun onMyLocationButtonClick(): Boolean {
        return true
    }

    override fun onMapReady(googleMap: GoogleMap) {
        (main_map_fragment as MainGoogleMapFragment).run {
            this.googleMap = googleMap
            googleMapReady(onMapAsyncCallback)
        }
    }
}