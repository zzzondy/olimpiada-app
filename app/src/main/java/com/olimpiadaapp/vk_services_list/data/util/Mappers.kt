package com.olimpiadaapp.vk_services_list.data.util

import com.olimpiadaapp.vk_services_list.data.remote.models.RemoteVKService
import com.olimpiadaapp.vk_services_list.data.remote.states.RemoteObtainingVKServicesListResult
import com.olimpiadaapp.vk_services_list.domain.models.VKService
import com.olimpiadaapp.vk_services_list.domain.states.ObtainingVKServicesListResult


fun RemoteObtainingVKServicesListResult.toDomain(): ObtainingVKServicesListResult =
    when (this) {
        is RemoteObtainingVKServicesListResult.Success ->
            ObtainingVKServicesListResult.Success(this.data.map { it.toDomain() })

        is RemoteObtainingVKServicesListResult.NetworkError ->
            ObtainingVKServicesListResult.NetworkError

        is RemoteObtainingVKServicesListResult.OtherError ->
            ObtainingVKServicesListResult.OtherError
    }

private fun RemoteVKService.toDomain(): VKService = VKService(
    name = name, description = description, iconUrl = iconUrl, serviceUrl = serviceUrl
)