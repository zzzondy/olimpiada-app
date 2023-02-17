package com.olimpiadaapp.vk_services_list.presentation.navigation

import java.net.URLEncoder
import java.nio.charset.StandardCharsets


sealed class VKServicesScreens(val route: String) {
    object VKServicesListScreen : VKServicesScreens(route = "vk_services_list_screen")
    object VKServiceDetailsScreen : VKServicesScreens(
        route = "vk_service_details_screen/{$VKServiceDetailsArgumentName}/" +
                "{$VKServiceDetailsArgumentDesc}/{$VKServiceDetailsArgumentIconUrl}/" +
                "{$VKServiceDetailsArgumentServiceUrl}"
    ) {
        fun passArguments(
            name: String,
            description: String,
            iconUrl: String,
            serviceUrl: String
        ): String {
            return this.route
                .replace("{$VKServiceDetailsArgumentName}", name)
                .replace("{$VKServiceDetailsArgumentDesc}", description)
                .replace(
                    "{$VKServiceDetailsArgumentIconUrl}",
                    URLEncoder.encode(iconUrl, StandardCharsets.UTF_8.toString())
                )
                .replace(
                    "{$VKServiceDetailsArgumentServiceUrl}",
                    URLEncoder.encode(serviceUrl, StandardCharsets.UTF_8.toString())
                )
        }
    }
}

const val VKServiceDetailsArgumentName = "name"
const val VKServiceDetailsArgumentDesc = "description"
const val VKServiceDetailsArgumentIconUrl = "icon_url"
const val VKServiceDetailsArgumentServiceUrl = "service_url"