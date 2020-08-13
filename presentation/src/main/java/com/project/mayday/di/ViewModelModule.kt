package com.project.mayday.di

import com.project.mayday.provider.ResourceProvider
import com.project.mayday.provider.ResourceProviderImpl
import com.project.mayday.ui.main.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.compat.ScopeCompat.viewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    single<ResourceProvider> { ResourceProviderImpl(androidApplication()) }


    viewModel { MainViewModel(get()) }
}