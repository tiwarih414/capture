package com.example.capture.grid_view.domain

data class ImageUseCases(
    val getImages: GetImagesUsecase,
    val deleteImage: DeleteImageUsecase,
    val insertImage: AddImagesUsecase
)
