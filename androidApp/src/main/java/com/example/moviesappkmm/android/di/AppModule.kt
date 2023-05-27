package com.example.moviesappkmm.android.di

import com.example.moviesappkmm.android.presentation.screens.home.HomeVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeVM(get()) }
}