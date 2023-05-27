package com.example.moviesappkmm.android.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesappkmm.domain.model.MovieModel
import com.example.moviesappkmm.domain.ui_state.MoviesUiState
import com.example.moviesappkmm.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@Suppress("UNCHECKED_CAST")
abstract class BaseViewModel : ViewModel() {
    protected fun <T> Flow<Resource<T>>.collectFlow(_state: MutableStateFlow<MoviesUiState>) {
        viewModelScope.launch(Dispatchers.IO) {
            this@collectFlow.collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        _state.value = MoviesUiState.Loading
                    }

                    is Resource.Success -> {
                        if (result.data != null) {
                            _state.value = MoviesUiState.Success(result.data as List<MovieModel>)
                        }
                    }

                    is Resource.Error -> {
                        _state.value = MoviesUiState.Error
                    }
                }
            }

        }
    }
}