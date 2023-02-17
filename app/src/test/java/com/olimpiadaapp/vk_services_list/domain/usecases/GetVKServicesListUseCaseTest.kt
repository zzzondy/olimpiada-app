package com.olimpiadaapp.vk_services_list.domain.usecases

import com.olimpiadaapp.vk_services_list.domain.models.VKService
import com.olimpiadaapp.vk_services_list.domain.repository.VKServicesRepository
import com.olimpiadaapp.vk_services_list.domain.states.ObtainingVKServicesListResult
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.kotlin.mock

@ExperimentalCoroutinesApi
class GetVKServicesListUseCaseTest {

    @Test
    fun `should return successful result`() = runTest {
        val dummyVKServicesRepository = mock<VKServicesRepository>()
        val getVKServicesListUseCase = GetVKServicesListUseCase(dummyVKServicesRepository)
        val dummyVKServicesList = listOf(VKService("", "", "", ""))

        `when`(dummyVKServicesRepository.getVKServicesList()).thenReturn(
            ObtainingVKServicesListResult.Success(
                dummyVKServicesList
            )
        )

        assertEquals(
            getVKServicesListUseCase(),
            ObtainingVKServicesListResult.Success(dummyVKServicesList)
        )

    }

    @Test
    fun `should return network error result`() = runTest {
        val dummyVKServicesRepository = mock<VKServicesRepository>()
        val getVKServicesListUseCase = GetVKServicesListUseCase(dummyVKServicesRepository)

        `when`(dummyVKServicesRepository.getVKServicesList()).thenReturn(
            ObtainingVKServicesListResult.NetworkError
        )

        assertEquals(getVKServicesListUseCase(), ObtainingVKServicesListResult.NetworkError)
    }

    @Test
    fun `should return other error result`() = runTest {
        val dummyVKServicesRepository = mock<VKServicesRepository>()
        val getVKServicesListUseCase = GetVKServicesListUseCase(dummyVKServicesRepository)

        `when`(dummyVKServicesRepository.getVKServicesList()).thenReturn(
            ObtainingVKServicesListResult.OtherError
        )

        assertEquals(getVKServicesListUseCase(), ObtainingVKServicesListResult.OtherError)
    }
}