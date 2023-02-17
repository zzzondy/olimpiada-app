package com.olimpiadaapp.vk_services_list.presentation.screens.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olimpiadaapp.core.dispatchers.DispatchersProvider
import com.olimpiadaapp.vk_services_list.domain.states.ObtainingVKServicesListResult
import com.olimpiadaapp.vk_services_list.domain.usecases.GetVKServicesListUseCase
import com.olimpiadaapp.vk_services_list.presentation.screens.list.states.VKServicesScreenEvent
import com.olimpiadaapp.vk_services_list.presentation.screens.list.states.VKServicesScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VKServicesListViewModel @Inject constructor(
    private val getVKServicesListUseCase: GetVKServicesListUseCase,
    private val dispatchersProvider: DispatchersProvider
) : ViewModel() {

    private val _vkServicesScreenState =
        MutableStateFlow<VKServicesScreenState>(VKServicesScreenState.Loading)
    val vkServicesScreenState = _vkServicesScreenState.asStateFlow()

    init {
        getVKServicesList()
    }


    fun onEvent(event: VKServicesScreenEvent) {
        when (event) {
            is VKServicesScreenEvent.OnRefreshClicked -> getVKServicesList()
        }
    }

    private fun getVKServicesList() {
        viewModelScope.launch(dispatchersProvider.io) {
            _vkServicesScreenState.update { VKServicesScreenState.Loading }
            _vkServicesScreenState.update {
                when (val result = getVKServicesListUseCase()) {
                    is ObtainingVKServicesListResult.Success -> {
                        VKServicesScreenState.VKServicesList(
                            result.data
                        )
                    }

                    is ObtainingVKServicesListResult.NetworkError -> VKServicesScreenState.NetworkError

                    is ObtainingVKServicesListResult.OtherError -> VKServicesScreenState.OtherError
                }
            }
        }
    }
}