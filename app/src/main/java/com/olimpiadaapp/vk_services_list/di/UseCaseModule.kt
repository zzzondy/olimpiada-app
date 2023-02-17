package com.olimpiadaapp.vk_services_list.di

import com.olimpiadaapp.vk_services_list.domain.repository.VKServicesRepository
import com.olimpiadaapp.vk_services_list.domain.usecases.GetVKServicesListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
class UseCaseModule {

    @ViewModelScoped
    @Provides
    fun provideGetVKServicesListUseCase(
        vkServicesRepository: VKServicesRepository
    ): GetVKServicesListUseCase =
        GetVKServicesListUseCase(vkServicesRepository)
}