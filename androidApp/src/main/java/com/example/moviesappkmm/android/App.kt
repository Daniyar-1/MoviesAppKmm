package com.example.moviesappkmm.android

import android.app.Application
import com.example.booksapi.di.dataModule
import com.example.moviesappkmm.android.di.appModule
import com.example.moviesappkmm.di.domainModule
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + listOf(domainModule, dataModule))
        }
    }
}