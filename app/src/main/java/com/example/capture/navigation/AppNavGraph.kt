package com.example.capture.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.capture.favorite.FavoriteView
import com.example.capture.grid_view.ui.GridView
import com.example.capture.setting.SettingView

@Composable
fun AppNavGraph(navController: NavHostController, padding: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = Screen.Grid.route,
        modifier = Modifier.padding(padding)
    ) {
        composable(route = Screen.Grid.route) {
            GridView(navController = navController)
        }

        composable(route = Screen.Favorite.route) {
            FavoriteView(navController = navController)
        }

        composable(route = Screen.Setting.route) {
            SettingView(navController = navController)
        }
    }
}