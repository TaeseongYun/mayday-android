package com.project.mayday.di

import android.app.Application
import com.project.data.di.dataModule
import com.project.local.di.localDataSourceModule
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
            localDataSourceModule,
            remoteDataSourceModule,
            networkModule
        )
    }
}