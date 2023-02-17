package com.olimpiadaapp.main.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.olimpiadaapp.main.navigation.Graphs
import com.olimpiadaapp.vk_services_list.presentation.navigation.vkServicesGraph

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Graphs.VKServicesListGraph.route,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        vkServicesGraph(navController)
    }
}