package com.olimpiadaapp.vk_services_list.presentation.screens.details.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.olimpiadaapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VKServiceDetailsScreenTopAppBar(title: String, onBackClicked: () -> Unit = {}) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(
                3.dp
            )
        ),
        navigationIcon = {
            IconButton(onClick = onBackClicked::invoke) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = stringResource(R.string.back_arrow)
                )
            }
        }
    )
}