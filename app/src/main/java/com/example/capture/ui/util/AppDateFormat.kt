package com.example.capture.ui.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object AppDateFormat {
    private const val JSON_TIME_1 = "hh:mm a"
    private val DF_JSON_TIME_1 = SimpleDateFormat(JSON_TIME_1, Locale.ENGLISH)

    private const val JSON_DATE_3 = "yyyyMMdd_HHmmss"
    val DF_JSON_DATE_3 = SimpleDateFormat(JSON_DATE_3, Locale.ENGLISH)

    fun getCurrentTime(): String {
        return DF_JSON_TIME_1.format(System.currentTimeMillis())
    }

    fun getCurrentDate(dateFormat: SimpleDateFormat): String {
        return dateFormat.format(Date())
    }
}