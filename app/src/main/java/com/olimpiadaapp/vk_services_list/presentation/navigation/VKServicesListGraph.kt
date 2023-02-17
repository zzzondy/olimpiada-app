package com.olimpiadaapp.vk_services_list.presentation.navigation

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.olimpiadaapp.main.navigation.Graphs
import com.olimpiadaapp.vk_services_list.domain.models.VKService
import com.olimpiadaapp.vk_services_list.presentation.screens.details.VKServiceDetailsScreen
import com.olimpiadaapp.vk_services_list.presentation.screens.list.VKServicesScreen

fun NavGraphBuilder.vkServicesGraph(navController: NavController) {
    navigation(
        startDestination = VKServicesScreens.VKServicesListScreen.route,
        route = Graphs.VKServicesListGraph.route
    ) {
        composable(VKServicesScreens.VKServicesListScreen.route) {
            VKServicesScreen(navController = navController)
        }

        composable(
            VKServicesScreens.VKServiceDetailsScreen.route,
            arguments = listOf(
                navArgument(VKServiceDetailsArgumentName) {
                    type = NavType.StringType
                },
                navArgument(VKServiceDetailsArgumentDesc) {
                    type = NavType.StringType
                },
                navArgument(VKServiceDetailsArgumentIconUrl) {
                    type = NavType.StringType
                },
                navArgument(VKServiceDetailsArgumentServiceUrl) {
                    type = NavType.StringType
                }
            )
        ) {
            VKServiceDetailsScreen(
                vkService = VKService(
                    name = it.arguments?.getString(VKServiceDetailsArgumentName).toString(),
                    description = it.arguments?.getString(VKServiceDetailsArgumentDesc)
                        .toString(),
                    iconUrl = it.arguments?.getString(VKServiceDetailsArgumentIconUrl)
                        .toString(),
                    serviceUrl = it.arguments?.getString(VKServiceDetailsArgumentServiceUrl)
                        .toString()
                ),
                navController = navController
            )
        }
    }
}