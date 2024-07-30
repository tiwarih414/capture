package com.example.capture.ui.util

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings

val checkIfVersionGreaterThanEqual34 = Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE
val checkIfVersionGreaterThanEqual33 = Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU

fun openAppSettings(requireActivity: Activity) {
    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
    val uri = Uri.fromParts("package", requireActivity.packageName, null)
    intent.data = uri
    requireActivity.startActivity(intent)
}