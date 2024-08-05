package com.example.capture.grid_view.domain

class DeleteImageUsecase(
    val repository: ImageRepository
) {
    suspend operator fun invoke(image: Image) {
        return repository.deleteImage(image)
    }
}