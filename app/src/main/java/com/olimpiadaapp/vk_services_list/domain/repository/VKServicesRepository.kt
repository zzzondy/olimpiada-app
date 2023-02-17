package com.olimpiadaapp.vk_services_list.domain.repository

import com.olimpiadaapp.vk_services_list.domain.states.ObtainingVKServicesListResult

interface VKServicesRepository {

    suspend fun getVKServicesList(): ObtainingVKServicesListResult
}