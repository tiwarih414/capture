package com.example.capture.grid_view.domain

sealed class OrderType {
    data object Ascending: OrderType()
    data object Descending: OrderType()
}