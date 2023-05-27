package com.example.moviesappkmm.domain.repo_interface

import com.example.moviesappkmm.domain.model.MovieModel
import com.example.moviesappkmm.utils.Resource
import kotlinx.coroutines.flow.Flow

internal interface MovieRepo {
    suspend fun getAllMovies(page: Int): Flow<Resource<List<MovieModel>>>
    suspend fun getMovieById(id: Int):MovieModel
}