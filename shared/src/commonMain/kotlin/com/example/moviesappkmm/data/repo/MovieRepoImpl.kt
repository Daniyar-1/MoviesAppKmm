package com.example.moviesappkmm.data.repo

import com.example.moviesappkmm.data.base.BaseRepository
import com.example.moviesappkmm.data.mapper.toDomain
import com.example.moviesappkmm.data.remote.RemoteDataSource
import com.example.moviesappkmm.domain.model.MovieModel
import com.example.moviesappkmm.domain.repo_interface.MovieRepo
import com.example.moviesappkmm.utils.Resource
import kotlinx.coroutines.flow.Flow

internal class MovieRepoImpl(
    private val remoteDataSource: RemoteDataSource
) : MovieRepo, BaseRepository() {

    override suspend fun getAllMovies(page: Int): Flow<Resource<List<MovieModel>>> = doReguest {
        remoteDataSource.getAllMovies(page).results.map {
            it.toDomain()
        }

        /*{
            return remoteDataSource.getAllMovies(page).result.map {
                it.toDomain()
            }*/
    }

    override suspend fun getMovieById(id: Int): MovieModel {
        return remoteDataSource.getMovieById(id).toDomain()
    }
}