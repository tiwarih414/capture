package com.example.capture.grid_view.domain

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Image(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val uri: Uri,
    val timeStamp: Long
)
