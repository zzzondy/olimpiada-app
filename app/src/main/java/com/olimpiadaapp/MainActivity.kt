package com.olimpiadaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.olimpiadaapp.main.ui.MainScreen
import com.olimpiadaapp.ui.theme.OlimpiadaAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContent {
            OlimpiadaAppTheme {
                MainScreen()
            }
        }
    }
}