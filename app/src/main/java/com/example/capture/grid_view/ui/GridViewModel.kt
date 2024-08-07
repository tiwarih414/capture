package com.example.capture.grid_view.ui

import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capture.grid_view.domain.ImageEntity
import com.example.capture.grid_view.domain.ImageOrder
import com.example.capture.grid_view.domain.ImageUseCases
import com.example.capture.grid_view.domain.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class GridViewModel @Inject constructor(
    private val imageUseCases: ImageUseCases
) : ViewModel() {
    private val _viewState = MutableStateFlow(GridViewState())
    var viewState = _viewState

    private val _showDialog = mutableStateOf(false)
    var showDialog = _showDialog

    init {
        getImages()
    }

    fun insertImages(photoUri: Uri) {
        val requestData = ImageEntity(
            uri = photoUri.toString(),
            timeStamp = System.currentTimeMillis(),
            height = (120..180).random()
        )
        viewModelScope.launch {
            imageUseCases.insertImage.invoke(imageEntity = requestData)
        }
    }

    fun getImages() {
        viewModelScope.launch {
            imageUseCases.getImages.invoke(ImageOrder.Date(OrderType.Ascending))
                .collectLatest { images ->
                    _viewState.update { vs -> vs.copy(imageEntities = images) }
                }
        }
    }
}