package com.juliensacre.testmsf.data.di

import androidx.room.Room
import com.juliensacre.testmsf.data.local.mapper.LocalMapper
import com.juliensacre.testmsf.data.local.room.DataBase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val localModule = module {

    single {
        Room.databaseBuilder(androidApplication(), DataBase::class.java, "trombi.db")
            .build()
    }

    factory { get<DataBase>().userDao() }

    factory { LocalMapper() }
}