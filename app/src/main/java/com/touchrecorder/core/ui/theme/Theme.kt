package com.touchrecorder.core.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val TouchRecorderColorScheme = darkColorScheme(
    primary = NeonPurple,
    onPrimary = Background,
    secondary = NeonPurple,
    onSecondary = TextPrimary,
    background = Background,
    onBackground = TextPrimary,
    surface = Surface,
    onSurface = TextPrimary,
    surfaceVariant = Surface,
    onSurfaceVariant = TextSecondary,
)

@Composable
fun TouchRecorderTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = TouchRecorderColorScheme,
        typography = Typography,
        content = content,
    )
}
