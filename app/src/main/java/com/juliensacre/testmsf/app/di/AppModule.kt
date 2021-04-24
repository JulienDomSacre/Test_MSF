package com.juliensacre.testmsf.app.di

import com.juliensacre.testmsf.data.di.dataModule
import com.juliensacre.testmsf.data.di.localModule
import com.juliensacre.testmsf.data.di.remoteModule
import com.juliensacre.testmsf.domain.di.domainModule
import com.juliensacre.testmsf.ui.di.uiModule

val appModule = listOf(
    remoteModule,
    localModule,
    dataModule,
    domainModule,
    uiModule
)