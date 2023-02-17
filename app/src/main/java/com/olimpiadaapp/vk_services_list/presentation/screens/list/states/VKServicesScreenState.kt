package com.olimpiadaapp.vk_services_list.presentation.screens.list.states

import com.olimpiadaapp.vk_services_list.domain.models.VKService

sealed class VKServicesScreenState {
    object Loading : VKServicesScreenState()
    data class VKServicesList(val data: List<VKService>) : VKServicesScreenState()
    object NetworkError : VKServicesScreenState()
    object OtherError : VKServicesScreenState()
}
