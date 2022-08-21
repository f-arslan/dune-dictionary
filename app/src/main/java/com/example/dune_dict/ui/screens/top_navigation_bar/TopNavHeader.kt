package com.example.dune_dict.ui.screens.top_navigation_bar

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Mic
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.dune_dict.R
import com.example.dune_dict.util.Constants.HIGH_PADDING
import com.example.dune_dict.util.Constants.VERY_HIGH_PADDING

@Composable
fun TopNavHeader(
    modifier: Modifier = Modifier,
    searchTextState: String,
    searchWidgetState: SearchWidgetState,
    onTextChange: (String) -> Unit = {},
    onClicked: () -> Unit = {},
    onDeleteBeforeClose: (String) -> Unit
) {

    Column(
        verticalArrangement = Arrangement.Top,
    ) {
        NavSearchBar(
            searchTextState = searchTextState,
            searchWidgetState = searchWidgetState,
            onTextChange = onTextChange,
            onClicked = onClicked,
            onDeleteBeforeClose = onDeleteBeforeClose
        )
    }
}

@Composable
private fun NavSearchBar(
    modifier: Modifier = Modifier,
    searchTextState: String,
    searchWidgetState: SearchWidgetState,
    onTextChange: (String) -> Unit = {},
    onClicked: () -> Unit = {},
    onDeleteBeforeClose: (String) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = HIGH_PADDING),
    ) {

        OutlinedTextField(
            value = searchTextState,
            onValueChange = {
                if (searchTextState.isEmpty()) {

                }
                onTextChange(it)
                onClicked()
            },
            label = { Text(text = stringResource(R.string.search_text)) },
            leadingIcon = { NavSearchIcon() },
            trailingIcon = {
                when (searchWidgetState) {
                    SearchWidgetState.CLOSED -> {
                        NavMicrophoneIcon()
                    }
                    SearchWidgetState.OPENED -> {
                        NavCloseIcon(
                            searchTextState = searchTextState,
                            onDeleteBeforeClose = onDeleteBeforeClose
                        )
                    }
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(VERY_HIGH_PADDING),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedLabelColor = MaterialTheme.colors.primary
            )

        )
    }
}

@Composable
private fun NavCloseIcon(
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
private fun NavMicrophoneIcon(
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
private fun NavSearchIcon(
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = {},
    ) {
        Icon(
            painter = painterResource(id = R.drawable.search),
            modifier = Modifier.size(VERY_HIGH_PADDING),
            contentDescription = stringResource(R.string.search_button),
        )
    }
}
