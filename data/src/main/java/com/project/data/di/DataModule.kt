package com.project.data.di

import com.project.data.Repository
import com.project.data.impl.RepositoryImpl
import org.koin.dsl.module

val dataModule = module {

    single<Repository> { RepositoryImpl(get(), get()) }

}