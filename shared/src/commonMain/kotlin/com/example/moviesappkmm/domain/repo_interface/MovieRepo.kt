package com.example.moviesappkmm.domain.repo_interface

import com.example.moviesappkmm.domain.model.MovieModel

internal interface MovieRepo {
    suspend fun getAllMovies(page: Int) : List<MovieModel>
    suspend fun getMovieById(id: Int):MovieModel
}