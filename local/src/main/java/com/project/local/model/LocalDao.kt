package com.project.local.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Maybe

@Dao
interface LocalDao {

    @Query("SELECT * FROM list")
    fun getMovieList(): Maybe<LocalItem>

    /* import android.arch.persistence.room.OnConflictStrategy.REPLACE */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: LocalItem): Completable

    @Query("DELETE from list")
    fun deleteAll()
}