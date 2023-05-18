package com.example.moviesappkmm.data.repo

import com.example.moviesappkmm.data.mapper.toDomain
import com.example.moviesappkmm.data.remote.RemoteDataSource
import com.example.moviesappkmm.domain.model.MovieModel
import com.example.moviesappkmm.domain.repo_interface.MovieRepo

internal class MovieRepoImpl(
    private val remoteDataSource: RemoteDataSource
) : MovieRepo {

    override suspend fun getAllMovies(page: Int): List<MovieModel> {
        return remoteDataSource.getAllMovies(page).result.map {
            it.toDomain()
        }
    }

    override suspend fun getMovieById(id: Int): MovieModel {
        return remoteDataSource.getMovieById(id).toDomain()
    }
}