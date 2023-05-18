package com.example.moviesappkmm.data.remote

import com.example.moviesappkmm.data.remote.model.MovieModelDto
import com.example.moviesappkmm.data.remote.model.MoviesResponse
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

internal class MoviesService : KtorApi() {
    suspend fun getAllMovies(page: Int = 1): MoviesResponse = client.get {
        pathUrl("movie/popular")
        parameter("page", page)
    }.body()

    suspend fun getMovieById(movieId: Int): MovieModelDto = client.get {
        pathUrl("movie/${movieId}")
    }.body()
}