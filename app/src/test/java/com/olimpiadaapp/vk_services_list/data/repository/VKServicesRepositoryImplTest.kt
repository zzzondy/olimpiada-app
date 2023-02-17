package com.olimpiadaapp.vk_services_list.data.repository

import com.olimpiadaapp.vk_services_list.data.remote.models.RemoteVKService
import com.olimpiadaapp.vk_services_list.data.remote.repository.RemoteVKServicesRepository
import com.olimpiadaapp.vk_services_list.data.remote.states.RemoteObtainingVKServicesListResult
import com.olimpiadaapp.vk_services_list.domain.models.VKService
import com.olimpiadaapp.vk_services_list.domain.states.ObtainingVKServicesListResult
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.kotlin.mock

@ExperimentalCoroutinesApi
class VKServicesRepositoryImplTest {

    @Test
    fun `should return successful result`() = runTest {
        val dummyRemoteVKServicesRepository = mock<RemoteVKServicesRepository>()
        val vkServicesRepositoryImpl = VKServicesRepositoryImpl(dummyRemoteVKServicesRepository)
        val dummyRemoteVKServicesList = listOf(RemoteVKService("", "", "", ""))
        val dummyVKServicesList = listOf(VKService("", "", "", ""))

        `when`(dummyRemoteVKServicesRepository.getVKServicesList()).thenReturn(
            RemoteObtainingVKServicesListResult.Success(dummyRemoteVKServicesList)
        )

        assertEquals(
            vkServicesRepositoryImpl.getVKServicesList(),
            ObtainingVKServicesListResult.Success(dummyVKServicesList)
        )
    }

    @Test
    fun `should return network error result`() = runTest {
        val dummyRemoteVKServicesRepository = mock<RemoteVKServicesRepository>()
        val vkServicesRepositoryImpl = VKServicesRepositoryImpl(dummyRemoteVKServicesRepository)

        `when`(dummyRemoteVKServicesRepository.getVKServicesList()).thenReturn(
            RemoteObtainingVKServicesListResult.NetworkError
        )

        assertEquals(vkServicesRepositoryImpl.getVKServicesList(), ObtainingVKServicesListResult.NetworkError)
    }

    @Test
    fun `should return other error result`() = runTest {
        val dummyRemoteVKServicesRepository = mock<RemoteVKServicesRepository>()
        val vkServicesRepositoryImpl = VKServicesRepositoryImpl(dummyRemoteVKServicesRepository)

        `when`(dummyRemoteVKServicesRepository.getVKServicesList()).thenReturn(
            RemoteObtainingVKServicesListResult.OtherError
        )

        assertEquals(vkServicesRepositoryImpl.getVKServicesList(), ObtainingVKServicesListResult.OtherError)
    }
}