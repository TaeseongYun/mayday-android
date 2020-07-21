package com.project.mayday.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder<B : ViewDataBinding>(
    @LayoutRes layoutRes: Int,
    parent: ViewGroup
) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)) {


    private val binding: B = DataBindingUtil.bind(itemView)!!

    open fun onBindViewHolder(
        item: Any?,
        position: Int,
        vm: Any
    ) {
        item?.let {
            with(binding) {
                setVariable(BR.index, position)
                setVariable(BR.item, item)
                setVariable(BR.vm, vm)
                executePendingBindings()
            }
        }
    }
}