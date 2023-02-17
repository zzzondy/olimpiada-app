package com.olimpiadaapp.vk_services_list.data.remote.states

import com.olimpiadaapp.vk_services_list.data.remote.models.RemoteVKService

sealed class RemoteObtainingVKServicesListResult {
    data class Success(val data: List<RemoteVKService>) : RemoteObtainingVKServicesListResult()
    object NetworkError : RemoteObtainingVKServicesListResult()
    object OtherError : RemoteObtainingVKServicesListResult()
}
