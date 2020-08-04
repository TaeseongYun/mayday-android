package com.project.domain.usecase

import com.project.domain.usecase.base.BaseUseCase
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

abstract class SingleUseCase<T, in E>(
    private val schedulersIO: Scheduler = Schedulers.io(),
    private val observeMainThread: Scheduler
) :
    BaseUseCase<E>() {

    abstract fun buildSingleUseCase(item: E): Single<T>

    override fun invoke(data: E): Any = buildSingleUseCase(data)
        .subscribeOn(schedulersIO)
        .observeOn(observeMainThread)
}