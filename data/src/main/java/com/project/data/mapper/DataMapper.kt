package com.project.data.mapper

interface DataMapper<T, E> {

    fun toDomain(data: E): T

    fun fromDomain(data: T): E
}