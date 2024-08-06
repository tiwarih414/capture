package com.example.capture.grid_view.domain

import kotlinx.coroutines.flow.Flow

interface ImageRepository {
    fun getImages(): Flow<List<ImageEntity>>
    suspend fun getImageById(id: Int): ImageEntity?
    suspend fun insertImage(imageEntity: ImageEntity)
    suspend fun deleteImage(imageEntity: ImageEntity)
}