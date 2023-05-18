package com.example.moviesappkmm.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MovieModelDto(
    val id: Int,
    val title: String,
    @SerialName("overview")
    val description: String,
    @SerialName("poster_path")
    val image: String,
    @SerialName("release_date")
    val releaseDate: String,

    )
