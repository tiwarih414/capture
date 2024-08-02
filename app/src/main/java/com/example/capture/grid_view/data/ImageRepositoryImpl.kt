package com.example.capture.grid_view.data

import com.example.capture.grid_view.domain.Image
import com.example.capture.grid_view.domain.ImageRepository
import kotlinx.coroutines.flow.Flow

class ImageRepositoryImpl(
    private val dao: ImageDao
) : ImageRepository {
    override fun getImages(): Flow<List<Image>> {
        return dao.getImages()
    }

    override suspend fun getImageById(id: Int): Image? {
        return dao.getImageById(id)
    }

    override suspend fun insertImage(image: Image) {
        return dao.insertImage(image)
    }

    override suspend fun deleteImage(image: Image) {
        return dao.deleteImage(image)
    }
}