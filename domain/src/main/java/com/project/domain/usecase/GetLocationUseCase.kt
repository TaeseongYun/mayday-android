package com.project.domain.usecase

import com.project.domain.usecase.base.BaseUseCase
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject

internal class GetLocationUseCase(observeMainThread: Scheduler) :
    BaseUseCase<Boolean>() {

    private val onLocationBehaviorSubject = BehaviorSubject.create<Boolean>()

    override fun invoke(
        data: Boolean,
        observeOn: Scheduler,
        onFinish: () -> Unit,
        onSuccess: (Boolean) -> Unit
    ): Any {
        onLocationBehaviorSubject.onNext(data)
        return onLocationBehaviorSubject
            .subscribeOn(Schedulers.io())
            .observeOn(observeOn)
            .onErrorReturn { false }
            .doAfterTerminate(onFinish)
            .subscribe(onSuccess)
    }
}