package com.example.capture.setting

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.capture.ui.theme.AppTheme
import com.example.capture.ui.theme.white

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingView(
    navController: NavHostController,
    viewModel: SettingViewModel = hiltViewModel()
) {
    AppTheme {
        Scaffold(
            containerColor = white
        ) {

        }
    }
}