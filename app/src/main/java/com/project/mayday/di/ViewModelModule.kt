package com.project.mayday.di

import com.project.mayday.provider.ResourceProvider
import com.project.mayday.provider.ResourceProviderImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val viewModelModule = module {

    single<ResourceProvider> { ResourceProviderImpl(androidApplication()) }


//    viewModel { ViewModel(get(), get()) }
}