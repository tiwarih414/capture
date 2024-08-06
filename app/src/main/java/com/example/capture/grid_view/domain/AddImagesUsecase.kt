package com.example.capture.grid_view.domain

class AddImagesUsecase(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(imageEntity: ImageEntity){
        return repository.insertImage(imageEntity)
    }
}