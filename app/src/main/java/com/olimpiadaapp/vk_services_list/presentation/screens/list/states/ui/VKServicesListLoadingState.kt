package com.olimpiadaapp.vk_services_list.presentation.screens.list.states.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.olimpiadaapp.ui.theme.OlimpiadaAppTheme
import com.olimpiadaapp.vk_services_list.presentation.screens.list.VKServiceItem

@Composable
fun VKServicesListLoadingState(modifier: Modifier = Modifier) {
    LazyColumn(userScrollEnabled = false, modifier = modifier) {
        items(VKServicesListLoadingStateConfig.PLACEHOLDERS_COUNT, key = { it }) {
            VKServiceItem(vkService = null)
        }
    }
}

private object VKServicesListLoadingStateConfig {
    const val PLACEHOLDERS_COUNT = 5
}

@Preview
@Composable
fun VKServicesListLoadingStatePreview() {
    OlimpiadaAppTheme(darkTheme = true) {
        VKServicesListLoadingState(modifier = Modifier.fillMaxSize())
    }
}