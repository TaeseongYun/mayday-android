package com.project.googlemap.binding

import android.view.View
import androidx.databinding.BindingAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.project.content.ext.ThrottleFirstClickListener
import io.reactivex.disposables.CompositeDisposable

private val disposable by lazy {
    CompositeDisposable()
}

@BindingAdapter("throttleOnClick")
fun FloatingActionButton.setOnThrottleClickListener(listener: View.OnClickListener) {
    setOnClickListener(ThrottleFirstClickListener(disposable = disposable) {
        it.run(listener::onClick)
    })
}