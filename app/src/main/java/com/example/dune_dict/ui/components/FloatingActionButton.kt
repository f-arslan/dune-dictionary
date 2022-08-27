package com.example.dune_dict.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.dune_dict.R
import com.example.dune_dict.ui.theme.appGradiantBrush
import com.example.dune_dict.util.Constants


@Composable
fun DuneFloatingActionButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},

) {
    val fabShape = AbsoluteCutCornerShape(50)
    FloatingActionButton(
        shape = fabShape,
        onClick = onClick,
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = Constants.MEDIUM_PADDING,
            pressedElevation = Constants.MEDIUM_HIGH_PADDING,
            hoveredElevation = Constants.HIGH_PADDING,
            focusedElevation = Constants.VERY_HIGH_PADDING
        ),
        backgroundColor = Color.Transparent,
        modifier = Modifier
            .size(64.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = MaterialTheme.colors.appGradiantBrush
                )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = stringResource(id = R.string.search_button),
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.Center),
                tint = MaterialTheme.colors.background
            )
        }
    }
}