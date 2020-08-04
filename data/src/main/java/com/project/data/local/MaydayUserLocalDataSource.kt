package com.project.data.local

import com.project.data.Local
import com.project.data.model.LocalItem
import io.reactivex.Completable
import io.reactivex.Single

interface MaydayUserLocalDataSource : Local {
    fun saveList(data: LocalItem): Completable
    fun getList(): Single<LocalItem>
    fun deleteList()
}