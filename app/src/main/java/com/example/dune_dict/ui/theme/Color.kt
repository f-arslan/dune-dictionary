package com.example.dune_dict.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.ColorSpace

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val DarkGray = Color(0xFF141414)
val WhiteLight = Color(0xFFFFFFFF)
val WhiteMedium = Color(248, 248, 248, 255)
val WhiteBold = Color(238, 238, 238, 255)


val Colors.navButtonsBackground: Color
    @Composable
    get() = if (isLight) WhiteBold else DarkGray

val Colors.navHeaderText: Color
    @Composable
    get() = if (isLight) Color.Black else Color.White