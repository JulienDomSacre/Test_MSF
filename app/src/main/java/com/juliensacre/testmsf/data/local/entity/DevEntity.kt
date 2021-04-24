package com.juliensacre.testmsf.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Dev_Table")
data class DevEntity (
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val description: String,
    val picture: String,
    val hired: String
)