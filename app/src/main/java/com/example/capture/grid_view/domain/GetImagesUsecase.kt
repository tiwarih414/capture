package com.example.capture.grid_view.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetImagesUsecase(
    private val repository: ImageRepository
) {
    operator fun invoke(imageOrder: ImageOrder = ImageOrder.Date(OrderType.Ascending)): Flow<List<Image>> {
        return repository.getImages().map { images ->
            when (imageOrder.orderType) {
                is OrderType.Ascending -> {
                    when (imageOrder) {
                        is ImageOrder.Date -> images.sortedBy { it.timeStamp }
                    }
                }

                is OrderType.Descending -> {
                    when (imageOrder) {
                        is ImageOrder.Date -> images.sortedByDescending { it.timeStamp }
                    }
                }
            }
        }
    }
}