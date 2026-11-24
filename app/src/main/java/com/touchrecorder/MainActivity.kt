package com.touchrecorder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import com.touchrecorder.core.ui.theme.TouchRecorderTheme
import com.touchrecorder.feature.navigation.AppNavigation

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TouchRecorderTheme {
                AppNavigation()
            }
        }
    }
}
