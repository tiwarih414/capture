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
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.capture.ui.theme.AppTheme
import com.example.capture.ui.theme.appColorBlue
import com.example.capture.ui.theme.black300
import com.example.capture.ui.theme.black900
import com.example.capture.ui.theme.white
import com.example.capture.ui.util.CameraGalleryDialog
import com.example.capture.ui.util.checkIfVersionGreaterThanEqual33
import com.example.capture.ui.util.checkIfVersionGreaterThanEqual34
import com.example.capture.ui.util.checkSelfPermission
import com.google.accompanist.permissions.ExperimentalPermissionsApi

//https://developer.android.com/about/versions/14/changes/partial-photo-video-access

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GridView(
    navController: NavHostController, viewModel: GridViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    if (viewModel.showDialog.value) {
        CameraGalleryDialog(viewModel = viewModel) {
            viewModel.showDialog.value = false
        }
    }

    AppTheme {
        val scopedStorageLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestMultiplePermissions()) {
            when {
                it.getOrDefault(
                    READ_MEDIA_IMAGES, false
                ) and it.getOrDefault(
                    READ_MEDIA_VISUAL_USER_SELECTED, false
                ) and it.getOrDefault(
                    CAMERA, false
                ) -> {
                    /*TODO show camera and gallery dialog here*/
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
                    /*TODO show camera and gallery dialog here*/
                }
            }
        }

        val externalStorageLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestMultiplePermissions()) {
            when {
                it.getOrDefault(
                    READ_EXTERNAL_STORAGE, false
                ) and it.getOrDefault(
                    CAMERA, false
                ) -> {
                    /*TODO show camera and gallery dialog here*/
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
                                    /*TODO show camera and gallery dialog here*/
                                } else {
                                    storageLauncher.launch(arrayOf(READ_MEDIA_IMAGES, CAMERA))
                                }
                            }

                            else -> {
                                if (checkSelfPermission(context, READ_EXTERNAL_STORAGE)
                                    && checkSelfPermission(context, CAMERA)
                                ) {
                                    /*TODO show camera and gallery dialog here*/
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
