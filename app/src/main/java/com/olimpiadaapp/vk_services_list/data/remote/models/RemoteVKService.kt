package com.olimpiadaapp.vk_services_list.data.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteVKService(
    val name: String,
    val description: String,

    @SerialName("icon_url")
    val iconUrl: String,

    @SerialName("service_url")
    val serviceUrl: String
)
