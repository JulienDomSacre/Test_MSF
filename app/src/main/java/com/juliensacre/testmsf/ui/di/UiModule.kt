package com.juliensacre.testmsf.ui.di

import com.juliensacre.testmsf.ui.trombi.TrombiViewModel
import com.juliensacre.testmsf.ui.trombi.mapper.TrombiUiDataMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { TrombiViewModel(trombiUseCase = get(), userMapperToUi = get()) }

    factory {
        TrombiUiDataMapper()
    }
}