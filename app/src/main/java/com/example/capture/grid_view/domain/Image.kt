package com.example.capture.grid_view.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Image(
    @PrimaryKey val id: Int? = null,
    val uri: String,
    val timeStamp: Long
)
