package com.example.moviesappkmm.di

import com.example.moviesappkmm.data.repo.MovieRepoImpl
import com.example.moviesappkmm.domain.repo_interface.MovieRepo
import com.example.moviesappkmm.domain.use_case.GetAllMoviesUseCase
import com.example.moviesappkmm.domain.use_case.GetMovieByIdUseCase
import org.koin.dsl.module

val domainModule = module {
    single<MovieRepo>{MovieRepoImpl(get( ))}
    factory { GetAllMoviesUseCase() }
    factory { GetMovieByIdUseCase() }
}