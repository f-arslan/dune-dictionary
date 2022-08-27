package com.example.dune_dict.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val DarkGray = Color(0xFF141414)
val WhiteBold = Color(238, 238, 238, 255)
val MediumBrown = Color(0xFFA5663A)
val Bone = Color(0xFFEEEEEE)

val Colors.navButtonsBackground: Color
    @Composable
    get() = if (isLight) WhiteBold else DarkGray

val Colors.headerTextColor: Brush
    @Composable
    get() =
        if (isLight)
            Brush.linearGradient(
                listOf(
                    MediumBrown,
                    MaterialTheme.colors.primaryVariant.copy(alpha = 0.8f)
                )
            )
        else Brush.linearGradient()

val Colors.appGradiantBrush: Brush
    @Composable
    get() =
        if (isLight)
            Brush.linearGradient(
            colors = listOf(
                MaterialTheme.colors.primary,
                MaterialTheme.colors.primaryVariant
            )
        )
        else Brush.linearGradient()