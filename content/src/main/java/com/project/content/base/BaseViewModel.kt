package com.project.content.base

import androidx.lifecycle.ViewModel
import com.project.content.ext.SingleLiveEvent
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