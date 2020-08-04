package com.project.mayday.base

import androidx.lifecycle.ViewModel
import com.project.mayday.component.SingleLiveEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlin.reflect.KClass

abstract class BaseViewModel : ViewModel() {

    private val disposable = CompositeDisposable()
    val eventSessionOut = SingleLiveEvent<KClass<*>>()

    protected fun Disposable.addDisposable() {
        disposable.add(this)
    }

    override fun onCleared() {
        super.onCleared()
    }

    fun unBindViewModel() {
        disposable.clear()
    }
}