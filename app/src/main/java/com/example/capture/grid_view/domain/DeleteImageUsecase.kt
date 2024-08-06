package com.example.capture.grid_view.domain

class DeleteImageUsecase(
    val repository: ImageRepository
) {
    suspend operator fun invoke(imageEntity: ImageEntity) {
        return repository.deleteImage(imageEntity)
    }
}