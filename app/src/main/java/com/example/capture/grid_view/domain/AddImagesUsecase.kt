package com.example.capture.grid_view.domain

class AddImagesUsecase(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(image: Image){
        return repository.insertImage(image)
    }
}