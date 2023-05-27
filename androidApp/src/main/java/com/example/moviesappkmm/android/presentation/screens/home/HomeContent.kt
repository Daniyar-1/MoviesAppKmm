package com.example.moviesappkmm.android.presentation.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.moviesappkmm.domain.model.MovieModel
import java.util.Arrays

@Composable
fun HomeContent(
    vm: HomeVM,
    modifier: Modifier = Modifier,
    movies: List<MovieModel>,
    navigateToDetail: (MovieModel) -> Unit,
) {

    Log.e("ololo", "HomeContent: "+movies.joinToString())
//    movies.add(MovieModel(1,"Foreg", "this is description", "https://i.ytimg.com/vi/e9ltAgFmPrU/maxresdefault.jpg", "12.02.22"))
//    movies.add(MovieModel(2,"Foreg", "this is description", "https://i.ytimg.com/vi/e9ltAgFmPrU/maxresdefault.jpg", "12.02.22"))
//    movies.add(MovieModel(3,"Foreg", "this is description", "https://i.ytimg.com/vi/e9ltAgFmPrU/maxresdefault.jpg", "12.02.22"))
//    movies.add(MovieModel(4,"Foreg", "this is description", "https://i.ytimg.com/vi/e9ltAgFmPrU/maxresdefault.jpg", "12.02.22"))
//    movies.add(MovieModel(5,"Foreg", "this is description", "https://i.ytimg.com/vi/e9ltAgFmPrU/maxresdefault.jpg", "12.02.22"))
//    movies.add(MovieModel(6,"Foreg", "this is description", "https://i.ytimg.com/vi/e9ltAgFmPrU/maxresdefault.jpg", "12.02.22"))
//    movies.add(MovieModel(7,"Foreg", "this is description", "https://i.ytimg.com/vi/e9ltAgFmPrU/maxresdefault.jpg", "12.02.22"))
//    movies.add(MovieModel(8,"Foreg", "this is description", "https://i.ytimg.com/vi/e9ltAgFmPrU/maxresdefault.jpg", "12.02.22"))
//    movies.add(MovieModel(9,"Foreg", "this is description", "https://i.ytimg.com/vi/e9ltAgFmPrU/maxresdefault.jpg", "12.02.22"))
//    movies.add(MovieModel(10,"Foreg", "this is description", "https://i.ytimg.com/vi/e9ltAgFmPrU/maxresdefault.jpg", "12.02.22"))
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 4.dp)
    ) {
        MainAppBar(
            searchWidgetState = vm.searchWidgetState.value,
            searchTextState = vm.searchTextState.value,
            onTextChange = { vm.updateSearchTextState(newValue = it) },
            onCloseClicked = { vm.updateSearchWidgetState(newValue = SearchWidgetState.CLOSED) },
            onSearchClicked = { },
            onSearchTriggered = { vm.updateSearchWidgetState(newValue = SearchWidgetState.OPENED) }
        )
        Box(
            modifier = modifier
                .fillMaxSize()
//                .pullRefresh(state = pullRefreshState)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                itemsIndexed(movies) { index, movie ->
                    MovieItem(movie = movie, onMovieClick = { navigateToDetail(movie) })

                    /*if (index >= uiState.movies.size -1 && !uiState.loading && !uiState.loadFinished){
                        LaunchedEffect(key1 = Unit, block = { loadNextMovies(false) })
                    }*/
                }

                /* if (uiState.loading && uiState.movies.isNotEmpty()){
                    item(span = { GridItemSpan(2) }){
                        Row(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CircularProgressIndicator(
                                color = Red
                            )
                        }
                    }
                }*/
            }
        }
    }
}