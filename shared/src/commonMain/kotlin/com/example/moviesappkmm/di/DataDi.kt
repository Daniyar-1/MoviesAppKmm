package com.example.booksapi.di

import com.example.moviesappkmm.data.remote.MoviesService
import com.example.moviesappkmm.data.remote.RemoteDataSource
import org.koin.dsl.module

val dataModule = module {
    factory { RemoteDataSource(get(), get()) }
    factory { MoviesService() }
}