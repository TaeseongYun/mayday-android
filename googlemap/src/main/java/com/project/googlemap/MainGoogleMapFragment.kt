package com.project.googlemap

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.project.googlemap.databinding.MainGoogleMapLayoutBinding
import com.project.googlemap.helper.AbstractGoogleMapHelper
import com.project.googlemap.viewmodel.GoogleMapViewModel
import kotlinx.android.synthetic.main.main_google_map_layout.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainGoogleMapFragment :
    AbstractGoogleMapHelper<MainGoogleMapLayoutBinding, GoogleMapViewModel>() {

    override val viewModel: GoogleMapViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind {
            lifecycleOwner = viewLifecycleOwner
            executePendingBindings()
        }
    }

    override fun googleMapReady(
        onMapAsyncCallback: (FragmentManager?) -> Unit,
        onMapReadyCallback: OnMapReadyCallback
    ) {
        googleMap.mapType = GoogleMap.MAP_TYPE_NORMAL
        onMapAsyncCallback(activity?.supportFragmentManager)
        (map_fragment as SupportMapFragment).getMapAsync(onMapReadyCallback)
    }
}