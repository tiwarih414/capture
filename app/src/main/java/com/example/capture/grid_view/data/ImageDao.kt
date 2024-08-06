package com.example.capture.grid_view.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.capture.grid_view.domain.ImageEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ImageDao {
    @Query("SELECT * FROM imageentity")
    fun getImages(): Flow<List<ImageEntity>>

    @Query("SELECT * FROM imageentity WHERE id = :id")
    suspend fun getImageById(id: Int): ImageEntity?

    @Insert
    suspend fun insertImage(images: ImageEntity)

    @Delete
    suspend fun deleteImage(images: ImageEntity)
}