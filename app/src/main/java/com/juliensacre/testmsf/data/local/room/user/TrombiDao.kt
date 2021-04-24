package com.juliensacre.testmsf.data.local.room.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.juliensacre.testmsf.data.local.entity.DevEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TrombiDao {
    @Insert
    suspend fun insertAll(trombi: List<DevEntity>)

    @Query("select * from dev_table")
    fun getTrombi(): Flow<List<DevEntity>>
}