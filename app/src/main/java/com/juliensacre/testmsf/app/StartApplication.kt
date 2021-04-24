package com.juliensacre.testmsf.app

import android.app.Application
import com.juliensacre.testmsf.app.di.appModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class StartApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        configureDi()
    }

    private fun configureDi() = startKoin {
        if (BuildConfig.DEBUG)
            androidLogger()
        androidContext(this@StartApplication)
        modules(appModule)
    }
}