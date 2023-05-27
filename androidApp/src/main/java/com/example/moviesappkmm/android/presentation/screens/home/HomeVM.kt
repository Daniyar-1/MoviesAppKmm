package com.example.moviesappkmm.android.presentation.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesappkmm.android.presentation.base.BaseViewModel
import com.example.moviesappkmm.domain.model.MovieModel
import com.example.moviesappkmm.domain.ui_state.MoviesUiState
import com.example.moviesappkmm.domain.use_case.GetAllMoviesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class HomeVM(
    private val getAllMoviesUseCase: GetAllMoviesUseCase,
) : BaseViewModel() {

    private var currentPage = 10
    var movies: List<MovieModel> = listOf()


    private val _getAllMoviesUseCase =
        MutableStateFlow<MoviesUiState>(MoviesUiState.Loading)
    val getAllMoviesStateFlow = _getAllMoviesUseCase.asStateFlow()

    private suspend fun loadMovies() {
        getAllMoviesUseCase(currentPage).collectFlow(_getAllMoviesUseCase)
    }

    init {
        viewModelScope.launch {
            loadMovies()
        }
    }

    private val _searchWidgetState: MutableState<SearchWidgetState> =
        mutableStateOf(value = SearchWidgetState.CLOSED)
    val searchWidgetState: State<SearchWidgetState> = _searchWidgetState

    private val _searchTextState: MutableState<String> =
        mutableStateOf(value = "")
    val searchTextState: State<String> = _searchTextState

    fun updateSearchWidgetState(newValue: SearchWidgetState) {
        _searchWidgetState.value = newValue
    }

    fun updateSearchTextState(newValue: String) {
        _searchTextState.value = newValue
    }
}

enum class SearchWidgetState {
    OPENED,
    CLOSED
}