package com.project.googlemap.helper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.project.googlemap.R

abstract class AbstractGoogleMapHelper<VIEW_BIND : ViewDataBinding, VM : ViewModel> :
    GoogleMapHelper, OnMapReadyCallback, Fragment() {
    override lateinit var googleMap: GoogleMap

    abstract val viewModel: VM

    lateinit var dataBinding: VIEW_BIND

    lateinit var onMapAsyncCallback: (FragmentManager?) -> Unit

    override fun onMapReady(customGoogleMaps: GoogleMap) {
        googleMap = customGoogleMaps
        googleMapReady(onMapAsyncCallback, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.main_google_map_layout, container, false)

        return dataBinding.root
    }

    fun bind(dataBindingSetter: VIEW_BIND.() -> Unit) {
        dataBinding.run(dataBindingSetter)
    }
}