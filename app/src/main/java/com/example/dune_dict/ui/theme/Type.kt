package com.example.dune_dict.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.dune_dict.R

val Athiti = FontFamily(
    Font(R.font.athiti_regular, FontWeight.Normal),
    Font(R.font.athiti_semibold, FontWeight.SemiBold),
    Font(R.font.athiti_bold, FontWeight.Bold),
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = Athiti,
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp
    ),
    body2 = TextStyle(
        fontFamily = Athiti,
        fontWeight = FontWeight.Normal,
        fontSize = 14.5.sp
    ),
    h5 = TextStyle(
        fontFamily = Athiti,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp,
        letterSpacing = 0.25.sp
    ),
    h6 = TextStyle(
        fontFamily = Athiti,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        letterSpacing = 0.25.sp
    )
)