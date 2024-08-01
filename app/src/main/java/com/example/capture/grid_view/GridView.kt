package com.example.capture.grid_view

import android.Manifest.permission.CAMERA
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.READ_MEDIA_IMAGES
import android.Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED
import android.annotation.SuppressLint
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.capture.ui.theme.AppTheme
import com.example.capture.ui.theme.black300
import com.example.capture.ui.theme.white
import com.example.capture.ui.util.CameraGalleryDialog
import com.example.capture.ui.util.checkIfVersionGreaterThanEqual33
import com.example.capture.ui.util.checkIfVersionGreaterThanEqual34
import com.example.capture.ui.util.checkSelfPermission

//https://developer.android.com/about/versions/14/changes/partial-photo-video-access

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GridView(
    navController: NavHostController, viewModel: GridViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    AppTheme {
        if (viewModel.showDialog.value){
            CameraGalleryDialog(
                viewModel = viewModel,
                onDismiss = { viewModel.showDialog.value = false },
                context = context
            )
        }

        val scopedStorageLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestMultiplePermissions()) {
            when {
                it.getOrDefault(
                    READ_MEDIA_IMAGES, false
                ) and it.getOrDefault(
                    READ_MEDIA_VISUAL_USER_SELECTED, false
                ) and it.getOrDefault(
                    CAMERA, false
                ) -> {
                    viewModel.showDialog.value = true
                }
            }
        }

        val storageLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestMultiplePermissions()) {
            when {
                it.getOrDefault(
                    READ_MEDIA_IMAGES, false
                ) and it.getOrDefault(
                    CAMERA, false
                ) -> {
                    viewModel.showDialog.value = true
                }
            }
        }

        val externalStorageLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestMultiplePermissions()) {
            when {
                it.getOrDefault(
                    CAMERA, false
                ) and it.getOrDefault(
                    READ_EXTERNAL_STORAGE, false
                ) -> {
                    viewModel.showDialog.value = true
                }
            }
        }

        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        when {
                            checkIfVersionGreaterThanEqual34 -> {
                                if (checkSelfPermission(context, READ_MEDIA_IMAGES)
                                    && checkSelfPermission(context, READ_MEDIA_VISUAL_USER_SELECTED)
                                    && checkSelfPermission(context, CAMERA)
                                ) {
                                    viewModel.showDialog.value = true
                                } else {
                                    scopedStorageLauncher.launch(
                                        arrayOf(
                                            READ_MEDIA_IMAGES,
                                            READ_MEDIA_VISUAL_USER_SELECTED,
                                            CAMERA
                                        )
                                    )
                                }
                            }

                            checkIfVersionGreaterThanEqual33 -> {
                                if (checkSelfPermission(context, READ_MEDIA_IMAGES)
                                    && checkSelfPermission(context, CAMERA)
                                ) {
                                    viewModel.showDialog.value = true
                                } else {
                                    storageLauncher.launch(arrayOf(READ_MEDIA_IMAGES, CAMERA))
                                }
                            }

                            else -> {
                                if (checkSelfPermission(context, READ_EXTERNAL_STORAGE)
                                    && checkSelfPermission(context, CAMERA)
                                ) {
                                    viewModel.showDialog.value = true
                                } else {
                                    externalStorageLauncher.launch(arrayOf(READ_EXTERNAL_STORAGE, CAMERA))
                                }
                            }
                        }
                    }, containerColor = black300, shape = CircleShape
                ) {
                    Icon(
                        Icons.Default.Add, contentDescription = "Add_Photos", tint = white
                    )
                }
            }, floatingActionButtonPosition = FabPosition.End, containerColor = white
        ) {

        }
    }
}
