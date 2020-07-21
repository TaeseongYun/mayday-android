package com.project.content.di

import com.project.content.ContentDataSource
import com.project.content.impl.ContentDataSourceImpl
import org.koin.dsl.module

val contentDataSourceModule = module {

    single<ContentDataSource> { ContentDataSourceImpl(get()) }
}