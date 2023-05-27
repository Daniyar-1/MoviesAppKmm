package com.example.moviesappkmm.data.base

import com.example.moviesappkmm.utils.Resource
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class BaseRepository {
    protected fun <T> doReguest (reguest: suspend () -> T) = flow {
        emit(Resource.Loading())
        try {
            val data = reguest()
            emit(Resource.Success(data))
        } catch (ioException: IOException) {
            emit(Resource.Error(ioException.message ?: "g"))
        }

    }.flowOn(Dispatchers.Default)
}