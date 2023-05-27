package com.example.moviesappkmm.android

import android.app.Application
import com.example.moviesappkmm.di.dataModule
import com.example.moviesappkmm.android.di.appModule
import com.example.moviesappkmm.di.domainModule
import com.example.moviesappkmm.di.getSharedModules
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModules())
        }
    }
}