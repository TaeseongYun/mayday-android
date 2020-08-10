package com.project.googlemap.di

import com.project.googlemap.viewmodel.GoogleMapViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val googleMapModule = module {
    viewModel { GoogleMapViewModel(get()) }
}