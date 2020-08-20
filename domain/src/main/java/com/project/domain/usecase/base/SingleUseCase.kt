package com.project.domain.usecase.base

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

abstract class SingleUseCase<T, E>(
    private val schedulersIO: Scheduler = Schedulers.io()
) :
    BaseUseCase<E>() {

    abstract fun buildSingleUseCase(item: E): Single<T>

    override fun invoke(
        data: E,
        observeOn: Scheduler,
        onFinish: () -> Unit,
        onSuccess: (E) -> Unit
    ): Any = buildSingleUseCase(data)
        .subscribeOn(schedulersIO)
        .doAfterTerminate(onFinish)
        .observeOn(observeOn)
}