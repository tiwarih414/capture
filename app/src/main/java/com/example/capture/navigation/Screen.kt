package com.example.capture.navigation

sealed class Screen(val route: String) {
    data object Grid : Screen("grid_screen")
    data object Preview : Screen("preview_screen")
    data object Favorite : Screen("favorite_screen")
    data object Setting : Screen("setting_screen")
}