package com.project.mayday.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.project.content.services.Permissions
import com.project.content.services.Permissions.REQUEST_LOCATION_PERMISSIONS
import com.project.content.services.Permissions.REQUEST_PERMISSIONS
import com.project.googlemap.MainGoogleMapFragment
import com.project.mayday.R
import com.project.mayday.base.BaseActivity
import com.project.mayday.databinding.ActivityMainBinding
import com.project.mayday.databinding.ActivityMainBindingImpl
import com.project.mayday.ext.toast
import com.project.mayday.ui.main.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : BaseActivity<ActivityMainBindingImpl, MainViewModel>(R.layout.activity_main),
    GoogleMap.OnMyLocationButtonClickListener, OnMapReadyCallback {

    override val vm: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (main_map_fragment as MainGoogleMapFragment).getMapAsync(this)

        (main_map_fragment as MainGoogleMapFragment).run {
            onMapAsyncCallback = {
                it?.findFragmentById(R.id.main_map_fragment)
            }
        }

        vm.permissionCheckLiveData.observe(this, Observer<Boolean> { isGranted ->
            if (!isGranted) {
                requestPermissions(REQUEST_PERMISSIONS.toTypedArray(), REQUEST_LOCATION_PERMISSIONS)
            } else {

                /* 현재 위치로 이동 코드 작성.*/
                val latLng = LatLng(37.566643, 126.978279);

                val position = CameraPosition.Builder()

                    .target(latLng).zoom(16f).build();

//                (main_map_fragment as SupportMapFragment).moveCamera(
//                    CameraUpdateFactory.newCameraPosition(
//                        position
//                    )
//                )
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

    override fun onMapReady(p0: GoogleMap?) {
        Log.e("onMapReady", "Hi")
    }
}