package com.olimpiadaapp.vk_services_list.presentation.screens.list.states.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.olimpiadaapp.R

@Composable
fun VKServicesListErrorState(modifier: Modifier = Modifier, onRefresh: () -> Unit = {}) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.round_wifi_off_24),
            contentDescription = stringResource(
                R.string.no_internet
            ),
            colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.primary),
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = stringResource(R.string.no_connection),
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(R.string.no_connection_details),
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onRefresh::invoke) {
            Text(text = stringResource(R.string.refresh))
        }
    }
}