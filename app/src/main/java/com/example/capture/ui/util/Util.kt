package com.example.capture.ui.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import java.io.File
import java.util.Date

val checkIfVersionGreaterThanEqual34 = Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE
val checkIfVersionGreaterThanEqual33 = Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU

fun openAppSettings(requireActivity: Activity) {
    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
    val uri = Uri.fromParts("package", requireActivity.packageName, null)
    intent.data = uri
    requireActivity.startActivity(intent)
}

fun Context.createImageFile(fileName: String): File {
    val timeStamp = AppDateFormat.DF_JSON_DATE_3.format(Date())
    val imageFileName = fileName + timeStamp + "_"
    val image = File.createTempFile(
        imageFileName,
        ".jpg",
        externalCacheDir
    )
    return image
}