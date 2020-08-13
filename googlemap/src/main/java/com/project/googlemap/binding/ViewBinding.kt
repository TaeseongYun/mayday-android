package com.project.googlemap.binding

import android.view.View
import androidx.databinding.BindingAdapter
import com.project.content.ext.ThrottleFirstClickListener
import io.reactivex.disposables.CompositeDisposable

@BindingAdapter("throttleOnClick")
fun View.setOnThrottleClickListener(listener: View.OnClickListener) {
    setOnClickListener(ThrottleFirstClickListener(disposable = CompositeDisposable()) {
        it.run(listener::onClick)
    })
}