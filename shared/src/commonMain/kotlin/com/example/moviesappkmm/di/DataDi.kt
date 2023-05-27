package com.example.moviesappkmm.di

import com.example.moviesappkmm.data.remote.MoviesService
import com.example.moviesappkmm.data.remote.RemoteDataSource
import org.koin.dsl.module

val dataModule = module {
    factory { RemoteDataSource(get(), get()) }
    factory { MoviesService() }
}
private val sharedModules = listOf(domainModule, dataModule, utilitiesModule)
fun getSharedModules() = sharedModules

