package com.project.local.impl

import com.project.data.LocalDataSource
import com.project.data.model.Entity
import com.project.local.model.LocalDao
import com.project.local.model.LocalItem
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers


class LocalDataSourceImpl(private val localItemDao: LocalDao) : LocalDataSource {

    override fun saveMovieList(data: Entity): Completable {
        return localItemDao.insert(
            LocalItem(
                id = System.currentTimeMillis(),
                list = data.items
            )
        )
    }


    override fun getMovieList(): Single<Entity> =
        localItemDao
            .getMovieList().map { Entity(items = it.list) }
            .toSingle()
            .subscribeOn(Schedulers.io())

    override fun deleteMovieList() {
        localItemDao.deleteAll()
    }
}