package com.example.capture.core

import androidx.annotation.StringRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.capture.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    @StringRes title: Int,
    onBack: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = title),
                style = TextStyle(
                    letterSpacing = 1.sp, fontWeight = FontWeight.Bold
                )
            )
        },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = stringResource(R.string.back)
                )
            }
        }
    )
}