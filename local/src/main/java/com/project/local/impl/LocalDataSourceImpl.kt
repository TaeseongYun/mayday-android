package com.project.local.impl

import com.project.local.model.LocalDao
import com.project.mayday.domain.local.LocalDataSource


/***
 * 코드는 다 지우기 애매해서 주석처리 해놓았습니다.
 ***/

class LocalDataSourceImpl(private val localItemDao: LocalDao) : LocalDataSource {

//    override fun saveMovieList(data: Entity): Completable {
//        return localItemDao.insert(
//            LocalItem(
//                id = System.currentTimeMillis(),
//                list = data.items
//            )
//        )
//    }
//
//
//    override fun getMovieList(): Single<Entity> =
//        localItemDao
//            .getMovieList().map { Entity(items = it.list) }
//            .toSingle()
//            .subscribeOn(Schedulers.io())
//
//    override fun deleteMovieList() {
//        localItemDao.deleteAll()
//    }
}