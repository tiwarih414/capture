package com.example.capture.ui.util

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

fun checkSelfPermission(context: Context, permission: String): Boolean {
    val result = ContextCompat.checkSelfPermission(context, permission)
    return result == PackageManager.PERMISSION_GRANTED
}