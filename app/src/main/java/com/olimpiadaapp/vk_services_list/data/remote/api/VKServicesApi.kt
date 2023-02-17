package com.olimpiadaapp.vk_services_list.data.remote.api

import com.olimpiadaapp.vk_services_list.data.remote.models.ObtainingVKServicesResponse
import retrofit2.Response
import retrofit2.http.GET

interface VKServicesApi {

    @GET("semi-final-data.json")
    suspend fun getVKServicesList(): Response<ObtainingVKServicesResponse>
}