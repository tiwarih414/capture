package com.example.capture.grid_view.data

import com.example.capture.grid_view.domain.ImageEntity
import com.example.capture.grid_view.domain.ImageRepository
import kotlinx.coroutines.flow.Flow

class ImageRepositoryImpl(
    private val dao: ImageDao
) : ImageRepository {
    override fun getImages(): Flow<List<ImageEntity>> {
        return dao.getImages()
    }

    override suspend fun getImageById(id: Int): ImageEntity? {
        return dao.getImageById(id)
    }

    override suspend fun insertImage(imageEntity: ImageEntity) {
        return dao.insertImage(imageEntity)
    }

    override suspend fun deleteImage(imageEntity: ImageEntity) {
        return dao.deleteImage(imageEntity)
    }
}