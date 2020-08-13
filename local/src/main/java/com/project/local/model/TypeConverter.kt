package com.project.local.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.project.data.model.Item

class TypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun toList(data: String?): List<Item> = when (data) {
        null -> emptyList()
        else -> gson.fromJson<List<Item>>(
            data,
            object : TypeToken<List<Item>>() {}.type
        )
    }

    @TypeConverter
    fun toString(contents: List<Item>): String {
        return gson.toJson(contents)
    }
}