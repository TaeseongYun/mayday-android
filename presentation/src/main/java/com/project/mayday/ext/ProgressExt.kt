package com.project.mayday.ext

import android.animation.ObjectAnimator
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

@BindingAdapter("bindProgressColor")
fun ProgressBar.setTintColor(res: Any?) {
    res?.let {
        progressTintList = when (it) {
            is Int -> ColorStateList.valueOf(ContextCompat.getColor(context, it))
            is String -> ColorStateList.valueOf(Color.parseColor("#$it"))
            else -> null
        }
    }
}

@BindingAdapter("android:progress")
fun ProgressBar.setProgressWithAnim(progress: Int) {
    ObjectAnimator.ofInt(this, "progress", 0, progress).apply {
        interpolator = AccelerateDecelerateInterpolator()
        duration = 500L
        start()
    }
}