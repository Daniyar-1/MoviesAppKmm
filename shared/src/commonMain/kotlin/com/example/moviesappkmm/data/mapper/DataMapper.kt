package com.example.moviesappkmm.data.mapper

import com.example.moviesappkmm.data.remote.model.MovieModelDto
import com.example.moviesappkmm.domain.model.MovieModel

private const val IMAGE_URL = "https://image.tmdb.org/t/p/w500/"

internal fun MovieModelDto.toDomain(): MovieModel {
    return MovieModel(
         id, title, description, image, releaseDate
    )
}

private fun getImageUrl(image: String): String {
    return IMAGE_URL+image
}