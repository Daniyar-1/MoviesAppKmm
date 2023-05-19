package com.example.moviesappkmm.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moviesappkmm.android.presentation.objects.Screen
import com.example.moviesappkmm.android.presentation.screens.home.Home
import com.example.moviesappkmm.android.presentation.screens.detail.Detail

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = Screen.HomeScreen.route
    ) {
        composable(Screen.HomeScreen.route) {
            Home()
        }
        composable(Screen.DetailScreen.route) {
            Detail()
        }
    }
}
