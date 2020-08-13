package com.project.content.di

import com.project.content.ContentDataSource
import com.project.content.impl.ContentDataSourceImpl
import com.project.content.services.PermissionHelper
import com.project.content.services.PermissionHelperImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val contentDataSourceModule = module {

    single<ContentDataSource> { ContentDataSourceImpl(get()) }
}

val contentPermissionModule = module {
    factory<PermissionHelper> { PermissionHelperImpl(androidContext()) }
}