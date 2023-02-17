package com.olimpiadaapp.vk_services_list.presentation.screens.list.states.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.olimpiadaapp.vk_services_list.domain.models.VKService
import com.olimpiadaapp.vk_services_list.presentation.screens.list.VKServiceItem

@Composable
fun VKServicesListState(
    items: List<VKService>,
    modifier: Modifier = Modifier,
    onVKServiceClicked: (VKService) -> Unit = {}
) {
    LazyColumn(modifier = modifier) {
        items(items, key = { it.name }) { vkService ->
            VKServiceItem(
                vkService = vkService,
                onVKServiceClicked = {
                    onVKServiceClicked(vkService)
                }
            )
        }
    }
}