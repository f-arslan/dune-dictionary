package com.example.dune_dict.ui.screens.top_header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.dune_dict.util.Constants.MEDIUM_PADDING


@Composable
fun TopHeader(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = MEDIUM_PADDING, top = MEDIUM_PADDING),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Dune Dictionary",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}


@Preview(showBackground = true)
@Composable
fun TopHeaderPreview() {
    TopHeader()
}