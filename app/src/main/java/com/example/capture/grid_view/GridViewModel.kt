package com.example.capture.grid_view

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class GridViewModel @Inject constructor() : ViewModel() {
    private val _viewState = MutableStateFlow(GridViewState())
    var viewState = _viewState

    private val _showDialog = mutableStateOf(false)
    var showDialog = _showDialog
}