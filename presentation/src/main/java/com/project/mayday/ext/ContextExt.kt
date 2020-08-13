package com.project.mayday.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.inputmethod.InputMethodManager

fun Context.startActivity(targetActivity: Class<out Any>) {
    val i = Intent(this, targetActivity)
    startActivity(i)
}

fun Context.startActivityWithData(targetActivity: Class<out Any>, block: Intent.() -> Unit) {
    val i = Intent(this, targetActivity)
    block(i)
    startActivity(i)
}

fun Context.resetActivity(targetActivity: Class<out Any>, block: Intent.() -> Unit) {
    val i = Intent(this, targetActivity)
    block(i)
    startActivity(i)
    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
}

fun Context.density(): Float {
    return resources.displayMetrics.density
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}