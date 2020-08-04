package com.project.domain.entity

data class LocalItem(
    val initTime: Long = 0,
    val items: List<Item>
)

data class Item(
    val sample0: Int = 0,
    val sample1: String = "",
    val sample2: String = ""
)