package com.example.capture.grid_view.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.capture.grid_view.domain.Image
import kotlinx.coroutines.flow.Flow

@Dao
interface ImageDao {
    @Query("SELECT * FROM image")
    fun getImages(): Flow<List<Image>>

    @Query("SELECT * FROM image WHERE id = :id")
    suspend fun getImageById(id: Int): Image?

    @Insert
    suspend fun insertImage(images: Image)

    @Delete
    suspend fun deleteImage(images: Image)
}