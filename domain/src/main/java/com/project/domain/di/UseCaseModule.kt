package com.project.domain.di

import com.project.domain.usecase.GetLocationUseCase
import com.project.domain.usecase.base.BaseUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single<BaseUseCase<Boolean>> { GetLocationUseCase() }
}