package com.project.mayday.ext

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

fun View.setTextColor(color: Int?) {
    color?.let {
        when (this) {
            is TextView -> setTextColor(ContextCompat.getColor(context, it))
            is Button -> setTextColor(ContextCompat.getColor(context, it))
        }
    }
}

fun View.setBgColor(color: Int?) {
    color?.let { setBackgroundColor(ContextCompat.getColor(context, it)) }

}

fun View.setBgDrawable(resourceId: Int?) {
    resourceId?.let { background = ContextCompat.getDrawable(context, it) }
}

@BindingAdapter("bindBackgroundTint")
fun View.setBgTint(colorCode: String?) {
    colorCode?.let { backgroundTintList = ColorStateList.valueOf(Color.parseColor("#$it")) }
}


//@BindingAdapter("hideKeyboard")
//fun View.hideKeyboard(value: Any?) {
//    setOnClickListener {
//        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.hideSoftInputFromWindow(windowToken, 0)
//    }
//}
