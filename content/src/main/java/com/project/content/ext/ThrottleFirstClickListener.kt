package com.project.content.ext

import android.view.View
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit

typealias ClickListener = (View) -> Unit

class ThrottleFirstClickListener(
    disposable: CompositeDisposable,
    private val listener: ClickListener
) : View.OnClickListener {
    private val onClickListenerBehaviorSubject = BehaviorSubject.create<View>()

    init {

        onClickListenerBehaviorSubject
            .throttleFirst(THROTTLE_DURATION, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                it.run(listener)
            }
            .addTo(disposable)
    }

    override fun onClick(view: View) {
        onClickListenerBehaviorSubject.onNext(view)
    }

    companion object {
        private const val THROTTLE_DURATION = 2000L
    }
}