package com.example.moviesappkmm.android.presentation.objects

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object DetailScreen : Screen("detail_screen")

    val routeDetailWithArgs: String
        get() = "${DetailScreen.route}/movieId"

    val argument = listOf(
        navArgument(name="movieId"){type = NavType.StringType}
    )
}

