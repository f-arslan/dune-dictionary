package com.example.dune_dict.ui.screens.top_navigation_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.example.dune_dict.ui.theme.navButtonsBackground
import com.example.dune_dict.util.Constants.HIGH_PADDING
import com.example.dune_dict.util.Constants.MEDIUM_HIGH_PADDING
import com.example.dune_dict.util.Constants.MEDIUM_PADDING
import com.example.dune_dict.util.Constants.SMALL_PADDING

@Composable
fun TopNavButtons(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = HIGH_PADDING,
                top = MEDIUM_PADDING,
                end = HIGH_PADDING,
                bottom = MEDIUM_PADDING
            )
            .clip(RoundedCornerShape(HIGH_PADDING)),
        elevation = MEDIUM_PADDING
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colors.navButtonsBackground)
                .padding(
                    start = MEDIUM_PADDING,
                    end = MEDIUM_PADDING,
                    bottom = SMALL_PADDING,
                    top = SMALL_PADDING
                )
        ) {
            Button(
                onClick = {},
                modifier = Modifier.weight(1f),
            ) {
                Text(text = "Random 30")
            }
            Spacer(modifier = Modifier.width(MEDIUM_PADDING))
            Button(
                onClick = {},
                modifier = Modifier.weight(1f),
            ) {
                Text(text = "My words")
            }
        }
    }
}


@Preview
@Composable
fun TopNavButtonsPreview() {
    TopNavButtons()
}