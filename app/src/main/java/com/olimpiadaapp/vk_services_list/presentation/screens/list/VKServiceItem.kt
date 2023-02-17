package com.olimpiadaapp.vk_services_list.presentation.screens.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.olimpiadaapp.core.utils.dpToPx
import com.olimpiadaapp.core.utils.shimmerEffect
import com.olimpiadaapp.vk_services_list.domain.models.VKService
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun VKServiceItem(vkService: VKService?, onVKServiceClicked: () -> Unit = {}) {
    val isLoading by rememberSaveable { mutableStateOf(vkService == null) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .clip(RoundedCornerShape(percent = 30))
            .clickable(enabled = vkService != null) {
                onVKServiceClicked()
            }
    ) {
        CoilImage(
            imageModel = { vkService?.iconUrl },
            modifier = Modifier
                .clip(RoundedCornerShape(percent = 30))
                .size(60.dp)
                .shimmerEffect(isLoading),
            imageOptions = ImageOptions(
                requestSize = IntSize(
                    width = 60.dp.dpToPx(),
                    height = 60.dp.dpToPx()
                )
            ),
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = if (isLoading) "" else vkService?.name ?: "",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .clip(RoundedCornerShape(percent = 30))
                .fillMaxWidth()
                .shimmerEffect(isLoading)
        )
    }
}