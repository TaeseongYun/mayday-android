package com.project.mayday.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.project.mayday.ext.resetActivity

abstract class BaseActivity<B : ViewDataBinding, VM : BaseViewModel>(@LayoutRes private val layoutResId: Int) :
    AppCompatActivity() {

    protected abstract val vm: VM
    protected lateinit var binding: B
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResId)
        binding.lifecycleOwner = this
        setSessionOut()
    }

    private fun setSessionOut() {
        vm.eventSessionOut.observe(this, Observer {
            resetActivity(it.java) {
                vm.clearData()
            }
        })
    }

    protected fun bind(action: B.() -> Unit) {
        binding.run(action)
    }
}