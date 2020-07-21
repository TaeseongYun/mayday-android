package com.project.mayday.component

import android.content.res.ColorStateList
import android.graphics.Color
import com.project.mayday.ext.trimBlank

object ConverterUtil {
    @JvmStatic
    fun trimBlank(rawString: String?) = rawString?.trimBlank()

    @JvmStatic
    fun parseColor(colorCode: String?): ColorStateList {
        return ColorStateList.valueOf(Color.parseColor("#${colorCode}"))
    }

    @JvmStatic
    fun toString(res: Any?): String? = res.toString()

}