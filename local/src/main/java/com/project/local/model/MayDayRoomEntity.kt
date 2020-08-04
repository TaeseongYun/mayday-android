package com.project.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.project.data.model.Item

@Entity(tableName = "list")
data class MayDayRoomEntity(
    @PrimaryKey(autoGenerate = true) var id: Long,
    val list: List<Item>
)