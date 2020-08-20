package com.project.domain.usecase.base

import com.project.domain.UseCase
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable

abstract class BaseUseCase<Params> : UseCase {
    internal val disposable by lazy { CompositeDisposable() }
    abstract operator fun invoke(
        data: Params, observeOn: Scheduler, onFinish: () -> Unit = {},
        onSuccess: (Params) -> Unit
    ): Any

    abstract fun behaviorHandler(data: Params)
}