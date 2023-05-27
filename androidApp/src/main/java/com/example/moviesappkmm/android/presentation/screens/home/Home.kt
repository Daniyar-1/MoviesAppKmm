package com.example.moviesappkmm.android.presentation.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.moviesappkmm.android.presentation.error.ErrorScreen
import com.example.moviesappkmm.android.presentation.loading.LoadingScreen
import com.example.moviesappkmm.domain.model.MovieModel
import com.example.moviesappkmm.domain.ui_state.MoviesUiState
import org.koin.androidx.compose.koinViewModel

@Composable
fun Home(
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    navigateToDetail: (MovieModel) -> Unit,
){
    val vm: HomeVM = koinViewModel()
    val moviesUiState by vm.getAllMoviesStateFlow.collectAsStateWithLifecycle()


    when (moviesUiState) {
        is MoviesUiState.Loading -> LoadingScreen(modifier)
        is MoviesUiState.Error -> ErrorScreen(retryAction)
        is MoviesUiState.Success -> HomeContent(
            vm,
            movies = (moviesUiState as MoviesUiState.Success).data,  navigateToDetail = navigateToDetail
        )
    }
}