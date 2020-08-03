package com.project.local.impl

import com.project.data.local.MaydayUserLocalDataSource
import com.project.data.model.LocalItem
import com.project.local.model.LocalDao
import com.project.local.model.MayDayRoomEntity
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers


class LocalDataSourceImpl(private val localItemDao: LocalDao) : MaydayUserLocalDataSource {

    override fun saveList(data: LocalItem): Completable {
        return localItemDao.insert(
            MayDayRoomEntity(
                id = System.currentTimeMillis(),
                list = data.items
            )
        )
    }

    override fun getList(): Single<LocalItem> =
        localItemDao
            .getList().map { LocalItem(items = it.list) }
            .toSingle()
            .subscribeOn(Schedulers.io())

    override fun deleteList() {
        localItemDao.deleteAll()
    }
}