package com.olimpiadaapp.vk_services_list.di

import com.olimpiadaapp.vk_services_list.data.remote.api.VKServicesApi
import com.olimpiadaapp.vk_services_list.data.remote.repository.RemoteVKServicesRepository
import com.olimpiadaapp.vk_services_list.data.remote.repository.RemoteVKServicesRepositoryImpl
import com.olimpiadaapp.vk_services_list.data.repository.VKServicesRepositoryImpl
import com.olimpiadaapp.vk_services_list.domain.repository.VKServicesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRemoteVKServicesRepository(vkServicesApi: VKServicesApi): RemoteVKServicesRepository =
        RemoteVKServicesRepositoryImpl(vkServicesApi)

    @Singleton
    @Provides
    fun provideVKServicesRepository(
        remoteVKServicesRepository: RemoteVKServicesRepository
    ): VKServicesRepository =
        VKServicesRepositoryImpl(remoteVKServicesRepository)
}