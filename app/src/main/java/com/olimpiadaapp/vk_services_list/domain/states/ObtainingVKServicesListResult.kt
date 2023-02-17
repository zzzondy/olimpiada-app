package com.olimpiadaapp.vk_services_list.domain.states

import com.olimpiadaapp.vk_services_list.domain.models.VKService

sealed class ObtainingVKServicesListResult {
    data class Success(val data: List<VKService>) : ObtainingVKServicesListResult()
    object NetworkError : ObtainingVKServicesListResult()
    object OtherError : ObtainingVKServicesListResult()
}
