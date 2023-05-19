package com.example.moviesappkmm.android.presentation.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.koinViewModel

@Composable
fun Home(){
    val vm: HomeVM = koinViewModel()
    HomeContent(vm = vm, modifier = Modifier, arrayListOf(),{})
}