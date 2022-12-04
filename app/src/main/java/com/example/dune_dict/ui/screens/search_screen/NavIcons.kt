package com.example.dune_dict.ui.screens.search_screen

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dune_dict.R
import com.example.dune_dict.util.Constants

@Composable
fun NavCloseIcon(
    modifier: Modifier = Modifier,
    searchTextState: String,
    onDeleteBeforeClose: (String) -> Unit
) {
    IconButton(
        onClick = {
            onDeleteBeforeClose(searchTextState)
        }
    ) {
        Icon(
            imageVector = Icons.Rounded.Close,
            contentDescription = stringResource(R.string.close_button)
        )
    }
}


@Composable
fun NavSearchIcon(
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = {},
    ) {
        Icon(
            painter = painterResource(id = R.drawable.search),
            modifier = Modifier
                .size(Constants.VERY_HIGH_PADDING),
            contentDescription = stringResource(R.string.search_button),
            tint = Color.Black
        )
    }
}


@Preview(showBackground = true)
@Composable
fun NavCloseIconPreview() {
    NavCloseIcon(searchTextState = "test", onDeleteBeforeClose = {})
}

@Preview(showBackground = true)
@Composable
fun NavSearchIconPreview() {
    NavSearchIcon()
}
