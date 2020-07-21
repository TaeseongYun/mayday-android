package com.project.local.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun toList(data: String?): List<LocalItem> = when (data) {
        null -> emptyList()
        else -> gson.fromJson<List<LocalItem>>(
            data,
            object : TypeToken<List<LocalItem>>() {}.type
        )
    }

    @TypeConverter
    fun toString(contents: List<LocalItem>): String {
        return gson.toJson(contents)
    }
}