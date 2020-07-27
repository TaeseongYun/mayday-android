package com.project.local.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

//@Database(entities = [LocalItem::class], version = 1)
//@TypeConverters(TypeConverter::class)
//abstract class LocalDataBase : RoomDatabase() {
//
//    abstract fun getItemDao(): LocalDao
//
//    companion object {
//        private lateinit var db: LocalDataBase
//        const val DB_NAME = "local.db"
//
//        fun getInstance(context: Context): LocalDataBase {
//            synchronized(LocalDataBase::class) {
//                db = Room.databaseBuilder(context, LocalDataBase::class.java, DB_NAME)
//                    .fallbackToDestructiveMigration()
//                    .build()
//            }
//            return db
//        }
//    }
//}