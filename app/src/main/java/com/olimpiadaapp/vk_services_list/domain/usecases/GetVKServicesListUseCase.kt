package com.olimpiadaapp.vk_services_list.domain.usecases

import com.olimpiadaapp.vk_services_list.domain.repository.VKServicesRepository
import com.olimpiadaapp.vk_services_list.domain.states.ObtainingVKServicesListResult

class GetVKServicesListUseCase(private val vkServicesRepository: VKServicesRepository) {

    suspend operator fun invoke(): ObtainingVKServicesListResult =
        vkServicesRepository.getVKServicesList()
}