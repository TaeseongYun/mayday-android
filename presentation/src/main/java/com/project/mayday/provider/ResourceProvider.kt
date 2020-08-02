package com.project.mayday.provider

import androidx.annotation.StringRes

interface ResourceProvider {

    fun getString(@StringRes res: Int): String
}