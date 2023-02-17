package com.olimpiadaapp.vk_services_list.presentation.screens.list.states

sealed class VKServicesScreenEvent {
    object OnRefreshClicked : VKServicesScreenEvent()
}