package com.example.dune_dict.ui.screens.random_words_screen.top_navigation_bar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TopNavigationBar(
    modifier: Modifier = Modifier
) {
    Column {
        TopAppBar(
            modifier = Modifier.fillMaxWidth()
        ) {
            TopNavHeader()
        }
        TopNavButtons()
    }
}


@Preview(showBackground = true)
@Composable
fun TopNavigationBarPreview() {
    TopNavigationBar()
}