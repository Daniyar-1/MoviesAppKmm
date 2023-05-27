package com.example.moviesappkmm.data.remote

import com.example.moviesappkmm.utils.DispatcherIO
import kotlinx.coroutines.withContext

internal class RemoteDataSource(
    private val apiService: MoviesService,
    private val dispatcherIO: DispatcherIO
) {
    suspend fun getAllMovies(page: Int) = withContext(dispatcherIO.io) {
        apiService.getAllMovies(page = page)
    }

    suspend fun getMovieById(movieId: Int) = withContext(dispatcherIO.io) {
        apiService.getMovieById(movieId = movieId)
    }
}