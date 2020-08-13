package com.project.googlemap.di

import com.project.googlemap.helper.gpstracker.GpsTracker
import com.project.googlemap.helper.gpstracker.GpsTrackerImpl
import com.project.googlemap.viewmodel.GoogleMapViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val googleMapModule = module {
    viewModel { GoogleMapViewModel(get()) }

    factory<GpsTracker> { GpsTrackerImpl(androidContext()) }
}