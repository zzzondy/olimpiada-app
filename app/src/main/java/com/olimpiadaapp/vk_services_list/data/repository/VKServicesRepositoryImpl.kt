package com.olimpiadaapp.vk_services_list.data.repository

import com.olimpiadaapp.vk_services_list.data.remote.repository.RemoteVKServicesRepository
import com.olimpiadaapp.vk_services_list.data.util.toDomain
import com.olimpiadaapp.vk_services_list.domain.repository.VKServicesRepository
import com.olimpiadaapp.vk_services_list.domain.states.ObtainingVKServicesListResult

class VKServicesRepositoryImpl(private val remoteVKServicesRepository: RemoteVKServicesRepository) :
    VKServicesRepository {

    override suspend fun getVKServicesList(): ObtainingVKServicesListResult =
        remoteVKServicesRepository.getVKServicesList().toDomain()
}