package com.project.mayday.base

import androidx.lifecycle.ViewModel
import com.project.mayday.component.SingleLiveEvent
import com.project.mayday.ui.main.MainActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlin.reflect.KClass

abstract class BaseViewModel(
//    protected val repository: Repository
) : ViewModel() {

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

    protected fun sessionErrorOut() {
        eventSessionOut.value = MainActivity::class
    }

    /***
     * 구현하신건 Repository 느낌 보다는 SharedPreference 느낌이 강해요.
     * 우선 주석으로 처리하고 푸시를 할게요 성재님 추가 작업하실 땐 수정하고 푸시 부탁드려요.
     ***/
//    protected fun getString(key: String) = repository.getString(key)
//
//    protected fun getInt(key: String) = repository.getInt(key)
//
//    protected fun getLong(key: String) = repository.getLong(key)
//
//    protected fun getBoolean(key: String) = repository.getBoolean(key)
//
//    protected fun putString(key: String, data: String) {
//        repository.putString(key, data)
//    }
//
//    protected fun putInt(key: String, data: Int) {
//        repository.putInt(key, data)
//    }
//
//    protected fun putLong(key: String, data: Long) {
//        repository.putLong(key, data)
//    }
//
//    protected fun putBoolean(key: String, data: Boolean) {
//        repository.putBoolean(key, data)
//    }
//
//    fun clearData() {
//        repository.clearData()
//    }
//
//    fun sendResetSignal(key: String) {
//        repository.putBoolean(key, true)
//    }
}