package com.olimpiadaapp.vk_services_list.presentation.screens.details

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.olimpiadaapp.core.utils.dpToPx
import com.olimpiadaapp.vk_services_list.domain.models.VKService
import com.olimpiadaapp.vk_services_list.presentation.screens.details.components.VKServiceDetailsScreenTopAppBar
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil.CoilImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VKServiceDetailsScreen(vkService: VKService, navController: NavController) {
    Scaffold(
        topBar = {
            VKServiceDetailsScreenTopAppBar(
                title = vkService.name,
                onBackClicked = { navController.popBackStack() }
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        VKServiceDetailsScreenContent(
            vkService,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        )
    }
}

@Composable
fun VKServiceDetailsScreenContent(vkService: VKService, modifier: Modifier = Modifier) {
    val urlIntent = Intent(
        Intent.ACTION_VIEW,
        Uri.parse(vkService.serviceUrl)
    )
    val context = LocalContext.current

    val annotatedVKServiceLinkString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.primary,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append(vkService.serviceUrl)
        }
    }

    Column(
        modifier = modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CoilImage(
            imageModel = { vkService.iconUrl },
            modifier = Modifier
                .clip(RoundedCornerShape(percent = 30))
                .size(70.dp),
            imageOptions = ImageOptions(
                requestSize = IntSize(
                    width = 70.dp.dpToPx(),
                    height = 70.dp.dpToPx()
                )
            ),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = vkService.name,
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = vkService.description, style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(16.dp))

        ClickableText(
            text = annotatedVKServiceLinkString,
            onClick = {
                context.startActivity(urlIntent)
            },
            modifier = Modifier.align(Alignment.Start),
        )
    }
}