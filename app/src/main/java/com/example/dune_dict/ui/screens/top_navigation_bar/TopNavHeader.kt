package com.example.dune_dict.ui.screens.top_navigation_bar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Mic
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.example.dune_dict.R
import com.example.dune_dict.data.models.SearchResultWord
import com.example.dune_dict.data.models.Word
import com.example.dune_dict.ui.screens.RequestState
import com.example.dune_dict.util.Constants.VERY_HIGH_PADDING

@Composable
fun TopNavHeader(
    modifier: Modifier = Modifier,
    searchTextState: String,
    searchWidgetState: SearchWidgetState,
    searchQueryListState: RequestState<List<SearchResultWord>>,
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
            searchQueryListState = searchQueryListState,
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
    searchQueryListState: RequestState<List<SearchResultWord>>,
    onTextChange: (String) -> Unit = {},
    onClicked: () -> Unit = {},
    onDeleteBeforeClose: (String) -> Unit,
) {

    val localFocusManager = LocalFocusManager.current

    Column {
        TextField(
            value = searchTextState,
            modifier = Modifier
                .fillMaxWidth(),
            onValueChange = {
                onTextChange(it)
                onClicked()
            },
            label = { Text(text = stringResource(R.string.search_text)) },
            leadingIcon = { NavSearchIcon() },
            trailingIcon = {
                when (searchWidgetState) {
                    SearchWidgetState.CLOSED -> {
                        NavMicrophoneIcon()
                        localFocusManager.clearFocus()
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
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    localFocusManager.clearFocus()
                }
            )
        )
        if (searchTextState.isNotEmpty()) {
            NavSearchResultBar(
                searchQueryListState = searchQueryListState
            )
        }
    }

}


