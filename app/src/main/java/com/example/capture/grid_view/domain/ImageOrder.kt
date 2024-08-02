package com.example.capture.grid_view.domain

sealed class ImageOrder(val orderType: OrderType) {
    class Date(orderType: OrderType): ImageOrder(orderType)
}