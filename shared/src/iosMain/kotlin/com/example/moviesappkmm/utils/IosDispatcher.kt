package com.example.moviesappkmm.utils

import com.example.moviesappkmm.utils.DispatcherIO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal class IosDispatcher : DispatcherIO {
    override val io: CoroutineDispatcher
        get() = Dispatchers.Default
}

internal actual fun provideDispatcher(): DispatcherIO = IosDispatcher()