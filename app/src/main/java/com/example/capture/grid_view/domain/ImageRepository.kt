package com.example.capture.grid_view.domain

import kotlinx.coroutines.flow.Flow

interface ImageRepository {
    fun getImages(): Flow<List<Image>>
    suspend fun getImageById(id: Int): Image?
    suspend fun insertImage(image: Image)
    suspend fun deleteImage(image: Image)
}