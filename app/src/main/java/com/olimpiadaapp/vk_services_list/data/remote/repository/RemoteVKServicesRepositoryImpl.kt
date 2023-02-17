package com.olimpiadaapp.vk_services_list.data.remote.repository

import com.olimpiadaapp.vk_services_list.data.remote.api.VKServicesApi
import com.olimpiadaapp.vk_services_list.data.remote.states.RemoteObtainingVKServicesListResult
import java.io.IOException

class RemoteVKServicesRepositoryImpl(private val vkServicesApi: VKServicesApi) :
    RemoteVKServicesRepository {

    override suspend fun getVKServicesList(): RemoteObtainingVKServicesListResult {
        return try {
            val result = vkServicesApi.getVKServicesList()
            if (result.isSuccessful) {
                RemoteObtainingVKServicesListResult.Success(result.body()!!.items)
            } else {
                RemoteObtainingVKServicesListResult.NetworkError
            }
        } catch (e: IOException) {
            RemoteObtainingVKServicesListResult.NetworkError
        } catch (e: Exception) {
            RemoteObtainingVKServicesListResult.OtherError
        }
    }
}