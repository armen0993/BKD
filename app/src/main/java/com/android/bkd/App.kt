package com.android.bkd

import android.app.Application
import com.android.bkd.module_view_model.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        start()

    }


    private fun start() {
        startKoin {
            androidLogger(org.koin.core.logger.Level.ERROR)
            androidContext(this@App)

            modules(
                viewModelModules
            )
        }
    }
}