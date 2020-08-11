package com.project.mayday

import android.app.Application
import com.project.content.di.contentPermissionModule
import com.project.data.di.dataModule
import com.project.googlemap.di.googleMapModule
import com.project.mayday.di.customUiModule
import com.project.mayday.di.viewModelModule
import com.project.mayday.ext.setUpKoin
import com.project.remote.di.networkModule
import com.project.remote.di.remoteDataSourceModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        setUpKoin(
            this@App,
            viewModelModule,
            dataModule,
            remoteDataSourceModule,
            networkModule,
            contentPermissionModule,
            googleMapModule,
            customUiModule
        )
    }
}