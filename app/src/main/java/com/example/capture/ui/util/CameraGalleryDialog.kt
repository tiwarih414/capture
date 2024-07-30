package com.example.capture.ui.util

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.window.Dialog
import androidx.core.content.FileProvider
import com.example.capture.R
import com.example.capture.grid_view.GridViewModel
import com.example.capture.ui.theme.AppSpacing
import com.example.capture.ui.theme.black300
import com.example.capture.ui.theme.spacing
import com.example.capture.ui.theme.white

/*https://github.com/KatieBarnett/Experiments/blob/main/jc-dialoganim/src/main/java/dev/katiebarnett/experiments/jcdialoganim/components/DialogAnimations.kt*/

@Composable
fun CameraGalleryDialog(
    viewModel: GridViewModel,
    onDismiss: () -> Unit,
) {
    val context = LocalContext.current

    val photoFile = context.createImageFile("capture_image_")
    var photoUri = FileProvider.getUriForFile(context, "${context.packageName}.provider", photoFile)

    val cameraLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) { success ->
        if (success) {
            println("Himanshu Camera Image : $photoUri")
        }
    }

    val galleryLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            photoUri = it
            println("Himanshu Gallery Image : $it")
        }
    }

    AnimatedVisibility(
        visible = viewModel.showDialog.value,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Dialog(
            onDismissRequest = onDismiss,
        ) {
            Surface(
                shape = RoundedCornerShape(spacing.small),
                color = white
            ) {
                Column(modifier = Modifier.padding(spacing.regular)) {
                    Text(
                        "Choose an option",
                        style = typography.headlineMedium,
                        color = black300
                    )
                    AppSpacing(height = spacing.tiny, width = spacing.regular)
                    TextButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            cameraLauncher.launch(photoUri)
                            onDismiss()
                        }) {
                        Text(
                            text = stringResource(id = R.string.camera),
                            textAlign = TextAlign.Start,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    AppSpacing(width = spacing.regular)
                    TextButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            galleryLauncher.launch("image/*")
                            onDismiss()
                        }) {
                        Text(
                            text = stringResource(id = R.string.gallery),
                            textAlign = TextAlign.Start,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}