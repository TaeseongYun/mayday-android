package com.project.local.impl

import com.project.data.local.MaydayUserLocalDataSource
import com.project.local.model.LocalDao


/***
 * 코드는 다 지우기 애매해서 주석처리 해놓았습니다.
 *
 *
 * 20200724 -> 메서드명 바꿨는데 애매하시면 지우셔도 됩니다.
 ***/

class LocalDataSourceImpl(private val localItemDao: LocalDao) : MaydayUserLocalDataSource {

//    override fun saveList(data: Entity): Completable {
//        return localItemDao.insert(
//            LocalItem(
//                id = System.currentTimeMillis(),
//                list = data.items
//            )
//        )
//    }
//
//
//    override fun getList(): Single<Entity> =
//        localItemDao
//            .getList().map { Entity(items = it.list) }
//            .toSingle()
//            .subscribeOn(Schedulers.io())
//
//    override fun deleteList() {
//        localItemDao.deleteAll()
//    }
}