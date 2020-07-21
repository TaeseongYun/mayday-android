package com.project.data

import com.project.data.model.Entity
import io.reactivex.Completable
import io.reactivex.Single

interface LocalDataSource {

    fun getMovieList(): Single<Entity>

    fun deleteMovieList()

    fun saveMovieList(entity: Entity): Completable

}