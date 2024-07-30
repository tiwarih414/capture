package com.example.capture

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.capture.navigation.AppNavGraph
import com.example.capture.navigation.BottomBar
import com.example.capture.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            AppTheme {
                navController = rememberNavController()
                Scaffold(
                    bottomBar = { BottomBar(navController = navController) },
                    containerColor = Color.White
                ) { paddingValues ->
                    AppNavGraph(navController = navController, paddingValues)
                }
            }
        }
    }
}