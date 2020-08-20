package com.project.domain.usecase.base

import com.project.domain.UseCase
import io.reactivex.Scheduler

abstract class BaseUseCase<Params> : UseCase {
    abstract operator fun invoke(
        data: Params, observeOn: Scheduler, onFinish: () -> Unit = {},
        onSuccess: (Params) -> Unit
    ): Any
}