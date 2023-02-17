package com.olimpiadaapp.core.utils

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun Dp.dpToPx(): Int = with(LocalDensity.current) { this@dpToPx.toPx() }.roundToInt()


fun Modifier.shimmerEffect(visible: Boolean): Modifier = composed {
    if (visible) {
        var size by remember {
            mutableStateOf(IntSize.Zero)
        }
        val transition = rememberInfiniteTransition()
        val startOffsetX by transition.animateFloat(
            initialValue = -2 * size.width.toFloat(),
            targetValue = 2 * size.width.toFloat(),
            animationSpec = infiniteRepeatable(
                animation = tween(1000)
            )
        )

        background(
            brush = Brush.linearGradient(
                colors = listOf(
                    MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp),
                    MaterialTheme.colorScheme.surfaceColorAtElevation(4.dp),
                    MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp),
                ),
                start = Offset(startOffsetX, 0f),
                end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat())
            )
        )
            .onGloballyPositioned {
                size = it.size
            }
    } else {
        this
    }
}