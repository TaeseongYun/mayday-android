package com.project.remote.di

import com.project.data.remote.MaydayRemoteDataSource
//import com.project.remote.impl.RemoteDataSourceImpl
import org.koin.dsl.module

val remoteDataSourceModule = module {
//    single<MaydayRemoteDataSource> { RemoteDataSourceImpl(get()) }
}