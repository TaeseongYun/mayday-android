package com.project.mayday.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.project.content.base.BaseViewModel
import com.project.mayday.ext.resetActivity
import com.project.mayday.BR

abstract class BaseActivity<B : ViewDataBinding, VM : ViewModel>(@LayoutRes private val layoutResId: Int) :
    AppCompatActivity() {

    protected abstract val vm: VM
    protected lateinit var binding: B
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@BaseActivity, layoutResId)
        bind {
            lifecycleOwner = this@BaseActivity
            setVariable(BR.vm, vm)
        }
        setSessionOut()
    }

    private fun setSessionOut() {
        (vm as BaseViewModel).eventSessionOut.observe(this, Observer {
            resetActivity(it.java) {
            }
        })
    }

    protected fun bind(action: B.() -> Unit) {
        binding.run(action)
    }
}