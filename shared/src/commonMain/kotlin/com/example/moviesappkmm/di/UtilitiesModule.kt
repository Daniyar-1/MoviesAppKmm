package com.example.moviesappkmm.di

import com.example.moviesappkmm.util.provideDispatcher
import org.koin.dsl.module

val utilitiesModule = module {
    factory { provideDispatcher() }
}