package com.example.dune_dict.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val LightColorPalette = lightColors(
    primary = Color(0xFFA5663A),
    primaryVariant = Color(0xFFE9CB8E),
    secondary = Color(0xFF2566B1),
    secondaryVariant = Color(0xFFA9D8DE),
    background = Color(0xFFF9F6FF),
    surface = Color(0xFFF9F6FF),
    error = Color(0xFFB00020),
    onPrimary = Color(0xFFF9F6FF),
    onSecondary = Color(0xFFF9F6FF),
    onBackground = Color.Black,
    onSurface = Color.Black,
    onError = Color(0xFFF9F6FF)
)

val DarkColorPalette = darkColors(
    primary = Color(0xFF1F1F1F),
    primaryVariant = Color(0xFF3E2723),
    secondary = Color(0xFF03DAC5),
    background = Color(0xFF121212),
    surface = Color.Black,
    error = Color(0xFFCF6679),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    onError = Color.Black
)

@Composable
fun DunedictTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}