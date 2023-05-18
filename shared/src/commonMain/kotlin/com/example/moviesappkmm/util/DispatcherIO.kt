package com.example.moviesappkmm.util

import kotlinx.coroutines.CoroutineDispatcher

internal interface DispatcherIO {
    val io: CoroutineDispatcher
}

internal expect fun provideDispatcher(): DispatcherIO