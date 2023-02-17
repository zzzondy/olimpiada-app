package com.olimpiadaapp.di

import com.olimpiadaapp.core.dispatchers.DispatchersProvider
import com.olimpiadaapp.core.dispatchers.StandardDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CoreModule {

    @Singleton
    @Provides
    fun provideDispatchersProvider(): DispatchersProvider = StandardDispatchers()
}