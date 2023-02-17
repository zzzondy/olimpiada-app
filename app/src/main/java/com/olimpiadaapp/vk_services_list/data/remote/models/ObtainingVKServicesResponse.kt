package com.olimpiadaapp.vk_services_list.data.remote.models

import kotlinx.serialization.Serializable

@Serializable
data class ObtainingVKServicesResponse(
    val items: List<RemoteVKService>
)
