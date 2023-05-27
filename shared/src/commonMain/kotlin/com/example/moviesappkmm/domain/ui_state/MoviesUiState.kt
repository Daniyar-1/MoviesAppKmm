package com.example.moviesappkmm.domain.ui_state

import com.example.moviesappkmm.domain.model.MovieModel


sealed class MoviesUiState {
    object Loading : MoviesUiState()
    class Success(val data: List<MovieModel>) : MoviesUiState()
    object Error : MoviesUiState()
}