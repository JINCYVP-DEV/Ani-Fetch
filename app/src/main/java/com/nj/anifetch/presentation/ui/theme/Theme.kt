package com.nj.anifetch.presentation.ui.theme
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = Orange,
    secondary = Black,
    tertiary = White,
    surface = LightOrange ,
)

@Composable
fun AniFetchTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), // Auto-switch based on system settings
    content: @Composable () -> Unit
) {
    val colors =  LightColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}