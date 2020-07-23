package com.project.data.mapper

interface Mapper<T, E> {
    fun toDomain(data: E): T

    fun fromDomain(data: T): E
}