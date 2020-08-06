package com.project.remote.mapper

interface RemoteMapper<T, E> {

    fun toData(data: E): T

    fun fromData(data: T): E
}