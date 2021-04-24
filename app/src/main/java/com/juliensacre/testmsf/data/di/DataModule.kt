package com.juliensacre.testmsf.data.di

import com.juliensacre.testmsf.data.Repository
import com.juliensacre.testmsf.domain.repository.IRepository
import org.koin.dsl.module

val dataModule = module {
    single<IRepository> {
        Repository(
            remoteDataSource = get(),
            localTrombiDao = get(),
            mapToEntity = get(),
            mapToModel = get()
        )
    }
}
