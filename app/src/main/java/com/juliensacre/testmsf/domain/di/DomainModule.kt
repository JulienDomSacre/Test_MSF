package com.juliensacre.testmsf.domain.di

import com.juliensacre.testmsf.domain.trombi.TrombiUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { TrombiUseCase(repo = get()) }
}
