package com.project.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.project.data.model.LocalItem

@Entity(tableName = "list")
data class LocalItem(
    @PrimaryKey(autoGenerate = true) var id: Long,
    val list: List<LocalItem>
)