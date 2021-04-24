package com.juliensacre.testmsf.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.juliensacre.testmsf.data.local.entity.DevEntity
import com.juliensacre.testmsf.data.local.room.user.TrombiDao

@Database(
    entities = [
        DevEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class DataBase : RoomDatabase() {
    abstract fun userDao(): TrombiDao
}