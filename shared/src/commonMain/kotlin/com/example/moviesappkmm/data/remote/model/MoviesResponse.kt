package com.example.moviesappkmm.data.remote.model

@kotlinx.serialization.Serializable
internal data class MoviesResponse(
    val results: List<MovieModelDto>
)
