package com.project.local.mapper

interface LocalMapper<T, E> {

    fun toData(data: E): T

    fun fromData(data: T): E
}