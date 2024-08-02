package com.example.capture.core

import com.example.capture.R

sealed class BottomNavItem(
    var route: String,
    var title: String,
    var icon: Int
) {
    data object Grid : BottomNavItem(
        "grid_screen",
        "Grid View",
        R.drawable.ic_grid
    )

    data object Favorite : BottomNavItem(
        "favorite_screen",
        "Favorite",
        R.drawable.ic_favorite
    )

    data object Settings : BottomNavItem(
        "setting_screen",
        "Settings",
        R.drawable.ic_settings
    )
}