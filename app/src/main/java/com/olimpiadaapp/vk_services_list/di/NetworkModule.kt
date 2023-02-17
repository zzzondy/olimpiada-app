package com.olimpiadaapp.vk_services_list.di

import com.olimpiadaapp.vk_services_list.data.remote.api.VKServicesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideVKServicesApi(retrofit: Retrofit): VKServicesApi =
        retrofit.create(VKServicesApi::class.java)
}