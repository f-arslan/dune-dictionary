package com.example.dune_dict.ui.screens.top_navigation_bar

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Mic
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
fun NavMicrophoneIcon(
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = {},
    ) {
        Icon(
            imageVector = Icons.Rounded.Mic,
            contentDescription = stringResource(R.string.microphone_button)
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
            modifier = Modifier.size(Constants.VERY_HIGH_PADDING),
            contentDescription = stringResource(R.string.search_button),
        )
    }
}
