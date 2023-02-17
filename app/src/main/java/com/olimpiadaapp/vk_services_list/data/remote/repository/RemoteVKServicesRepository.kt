package com.olimpiadaapp.vk_services_list.data.remote.repository

import com.olimpiadaapp.vk_services_list.data.remote.states.RemoteObtainingVKServicesListResult

interface RemoteVKServicesRepository {

    suspend fun getVKServicesList(): RemoteObtainingVKServicesListResult
}