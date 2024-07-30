package com.example.capture.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    val default: Dp = 0.dp,
    val tiny: Dp = 4.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 12.dp,
    val regular: Dp = 16.dp,
    val regularLarge: Dp = 20.dp,
    val large: Dp = 24.dp,
    val xl: Dp = 28.dp,
    val xxl: Dp = 32.dp,
    val xxxl: Dp = 36.dp,
    val xxxxl: Dp = 40.dp,
    val xxxxxl: Dp = 44.dp,
)

val LocalSpacing = compositionLocalOf { Spacing() }

val spacing: Spacing
    @Composable
    @ReadOnlyComposable
    get() = LocalSpacing.current
