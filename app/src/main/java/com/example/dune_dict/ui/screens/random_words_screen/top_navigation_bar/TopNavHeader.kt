package com.example.dune_dict.ui.screens.random_words_screen.top_navigation_bar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.example.dune_dict.R
import com.example.dune_dict.ui.theme.navHeaderText
import com.example.dune_dict.util.Constants.VERY_HIGH_PADDING

@Composable
fun TopNavHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "Dune Dictionary",
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.navHeaderText
        )
        IconButton(
            onClick = {},
        ) {
            Icon(
                painter = painterResource(id = R.drawable.search),
                modifier = Modifier.size(VERY_HIGH_PADDING),
                contentDescription = "Search Icon",
            )
        }
    }
}