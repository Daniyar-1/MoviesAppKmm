package com.example.moviesappkmm.utils

import kotlinx.coroutines.CoroutineDispatcher

internal interface DispatcherIO {
    val io: CoroutineDispatcher
}

internal expect fun provideDispatcher(): DispatcherIO