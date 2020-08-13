package com.project.mayday.ext

import android.util.Log
import androidx.annotation.LayoutRes
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.project.mayday.base.BaseRecyclerViewAdapter

@Suppress("UNCHECKED_CAST")
@BindingAdapter(
    "bindContentItem",
    "bindContentItemLayout",
    "bindHeaderItem",
    "bindHeaderItemLayout",
    "bindFooterItem",
    "bindFooterItemLayout",
    "bindVm",
    requireAll = false
)
fun RecyclerView.setRecyclerViewAdapter(
    contentItem: List<Any>? = null,
    @LayoutRes contentItemRes: Int? = null,
    headerItem: Any? = null,
    @LayoutRes headerItemRes: Int? = null,
    footerItem: Any? = null,
    @LayoutRes footerItemRes: Int? = null,
    vm: Any? = null
) {
    val adapter = adapter as? BaseRecyclerViewAdapter ?: BaseRecyclerViewAdapter()
    adapter.apply {
        this.contentItem = contentItem
        this.contentLayoutResId = contentItemRes
        this.headerItem = headerItem
        this.headerLayoutResId = headerItemRes
        this.footerItem = footerItem
        this.footerLayoutResId = footerItemRes
        this.vm = vm
    }
    this.adapter = adapter

    contentItem?.let {
        adapter.updateData(it)
        adapter.notifyDataSetChanged()
    }
}