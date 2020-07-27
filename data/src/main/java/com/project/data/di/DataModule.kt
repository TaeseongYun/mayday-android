package com.project.data.di

import com.project.data.impl.RepositoryImpl
import com.project.mayday.domain.Repository
import org.koin.dsl.module


val dataModule = module {
    single<Repository> { RepositoryImpl(get(), get()) }
}