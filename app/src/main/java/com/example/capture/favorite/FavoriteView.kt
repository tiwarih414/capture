package com.example.capture.favorite

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.capture.ui.theme.AppTheme
import com.example.capture.ui.theme.white

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FavoriteView(
    navController: NavHostController,
    viewModel: FavoriteViewModel = hiltViewModel()
) {
    AppTheme {
        Scaffold(
            containerColor = white
        ) {

        }
    }
}