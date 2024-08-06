package com.example.capture.grid_view.ui

import com.example.capture.grid_view.domain.ImageEntity

data class GridViewState(
    val imageEntities: List<ImageEntity> = emptyList()
)
