package com.example.dune_dict.ui.screens.top_header

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dune_dict.Screens
import com.example.dune_dict.ui.theme.appGradiantBrush
import com.example.dune_dict.ui.theme.headerTextColor
import com.example.dune_dict.ui.use_cases.textBrush
import com.example.dune_dict.util.Constants.MEDIUM_PADDING


@Composable
fun TopHeader(
    modifier: Modifier = Modifier,
    currentPageState: Screens = Screens.HomeScreen,
    currentPageTitleName: String,
) {

    val currentTitle: String = if (currentPageTitleName != "") {
        currentPageTitleName
    } else {
        currentPageState.title
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = MEDIUM_PADDING, top = MEDIUM_PADDING),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = currentTitle,
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .fillMaxWidth()
                .textBrush(
                    MaterialTheme.colors.headerTextColor
                ),
            textAlign = TextAlign.Center,
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = MEDIUM_PADDING)
                .height(2.5.dp)
                .border(
                    BorderStroke(
                        2.5.dp,
                        brush = MaterialTheme.colors.appGradiantBrush
                    )
                )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun TopHeaderPreview() {
    TopHeader(currentPageState = Screens.HomeScreen, currentPageTitleName = "")
}