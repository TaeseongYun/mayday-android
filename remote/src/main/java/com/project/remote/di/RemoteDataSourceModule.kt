package com.project.remote.di

import com.project.mayday.domain.remote.RemoteDataSource
import com.project.remote.impl.RemoteDataSourceImpl
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }
}