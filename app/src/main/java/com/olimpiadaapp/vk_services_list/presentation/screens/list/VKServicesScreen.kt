package com.olimpiadaapp.vk_services_list.presentation.screens.list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.olimpiadaapp.R
import com.olimpiadaapp.vk_services_list.presentation.navigation.VKServicesScreens
import com.olimpiadaapp.vk_services_list.presentation.screens.list.components.VKServicesScreenTopAppBar
import com.olimpiadaapp.vk_services_list.presentation.screens.list.states.VKServicesScreenEvent
import com.olimpiadaapp.vk_services_list.presentation.screens.list.states.VKServicesScreenState
import com.olimpiadaapp.vk_services_list.presentation.screens.list.states.ui.VKServicesListErrorState
import com.olimpiadaapp.vk_services_list.presentation.screens.list.states.ui.VKServicesListLoadingState
import com.olimpiadaapp.vk_services_list.presentation.screens.list.states.ui.VKServicesListState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VKServicesScreen(
    navController: NavController,
    vkServicesListViewModel: VKServicesListViewModel = hiltViewModel()
) {
    val screenState by vkServicesListViewModel.vkServicesScreenState.collectAsState()

    Scaffold(
        topBar = {
            VKServicesScreenTopAppBar(title = stringResource(R.string.vk_projects))
        },
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        when (screenState) {
            is VKServicesScreenState.Loading -> {
                VKServicesListLoadingState(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                )
            }

            is VKServicesScreenState.VKServicesList -> {
                VKServicesListState(
                    items = (screenState as VKServicesScreenState.VKServicesList).data,
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize(),
                    onVKServiceClicked = { vkService ->
                        navController.navigate(
                            VKServicesScreens.VKServiceDetailsScreen.passArguments(
                                name = vkService.name,
                                description = vkService.description,
                                iconUrl = vkService.iconUrl,
                                serviceUrl = vkService.serviceUrl
                            )
                        ) {
                            launchSingleTop = true
                        }
                    }
                )
            }

            else -> {
                VKServicesListErrorState(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize(),
                    onRefresh = {
                        vkServicesListViewModel.onEvent(VKServicesScreenEvent.OnRefreshClicked)
                    }
                )
            }
        }
    }
}