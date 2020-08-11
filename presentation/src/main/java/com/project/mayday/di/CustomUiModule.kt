package com.project.mayday.di

import androidx.fragment.app.FragmentManager
import com.project.content.base.BaseViewModel
import com.project.mayday.ui.main.bottomsheet.CustomBottomSheet
import org.koin.dsl.module

val customUiModule = module {
    factory { (viewModel: BaseViewModel, supportFragmentManager: FragmentManager) ->
        CustomBottomSheet(
            viewModel,
            supportFragmentManager = supportFragmentManager
        )
    }
}