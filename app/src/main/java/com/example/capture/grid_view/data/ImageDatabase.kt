package com.example.capture.grid_view.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.capture.grid_view.domain.Image
import javax.xml.validation.Schema

@Database(
    entities = [Image::class],
    version = 1
)
abstract class ImageDatabase : RoomDatabase() {
    abstract val imageDao: ImageDao

    companion object {
        const val DATABASE_NAME = "image_db"
    }
}