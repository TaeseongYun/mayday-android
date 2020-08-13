package com.project.mayday.ui.main.bottomsheet

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IntegerRes
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.project.content.base.BaseViewModel
import com.project.mayday.BR
import com.project.mayday.R


class CustomBottomSheet(
    private val viewModel: BaseViewModel,
    private val supportFragmentManager: FragmentManager
) :
    BottomSheetDialogFragment() {

    lateinit var dataBinding: ViewDataBinding

    @LayoutRes private var layout: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding =
            DataBindingUtil.inflate<ViewDataBinding>(inflater, layout ?: 0, container, false)
                .also {
                    when (layout) {
                        R.layout.mayday_saved_bottom_sheet_layout -> {
                            it.setVariable(BR.vm, viewModel)
//                            it.executePendingBindings()
                            it.lifecycleOwner = viewLifecycleOwner
                        }
                    }
                }

        return dataBinding.root
    }

    fun showDialog(bottomSheetLayout: Int) {
        if (!isAdded) {
            layout = bottomSheetLayout
            show(fragmentManager ?: supportFragmentManager, tag)
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        BottomSheetDialog(requireContext(), theme)
}