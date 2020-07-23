package com.project.local.di

import androidx.room.Room
import com.project.data.local.MaydayUserLocalDataSource
import com.project.local.impl.LocalDataSourceImpl
import com.project.local.model.LocalDataBase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val localDataSourceModule = module {
    single<LocalDataBase> {
        Room.databaseBuilder(androidApplication(), LocalDataBase::class.java, LocalDataBase.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<LocalDataBase>().getItemDao() }

    single<MaydayUserLocalDataSource> { LocalDataSourceImpl(get()) }
}