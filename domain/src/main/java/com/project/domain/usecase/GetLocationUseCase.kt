package com.project.domain.usecase

import com.project.domain.usecase.base.BaseUseCase
import io.reactivex.Scheduler
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject

internal class GetLocationUseCase :
    BaseUseCase<Boolean>() {

    private val onLocationBehaviorSubject = BehaviorSubject.create<Boolean>()

    override fun invoke(
        data: Boolean,
        observeOn: Scheduler,
        onFinish: () -> Unit,
        onSuccess: (Boolean) -> Unit
    ): Any {
        onLocationBehaviorSubject.onNext(data)

        return if (!data) {

        } else {
            onLocationBehaviorSubject
                .subscribeOn(Schedulers.io())
                .observeOn(observeOn)
                .filter { it }
                .onErrorReturn { false }
                .doAfterTerminate(onFinish)
                .subscribe(onSuccess)
                .addTo(disposable)
        }
    }

    override fun behaviorHandler(data: Boolean) {
        onLocationBehaviorSubject.onNext(data)
    }
}