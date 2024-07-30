package com.example.capture.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

private val DarkColorScheme = darkColorScheme(
    primary = appColor,
    secondary = blue600,
    tertiary = white
)

private val LightColorScheme = lightColorScheme(
    primary = appColor,
    secondary = blue600,
    tertiary = white
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    CompositionLocalProvider(LocalSpacing provides Spacing()) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}

@Composable
fun VerticalSpacing(spacing: Dp) = Spacer(modifier = Modifier.height(spacing))

@Composable
fun HorizontalSpacing(spacing: Dp) = Spacer(modifier = Modifier.width(spacing))