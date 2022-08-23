package com.example.dune_dict.ui.screens.search_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.dune_dict.R
import com.example.dune_dict.data.models.SearchResultWord
import com.example.dune_dict.ui.screens.RequestState
import com.example.dune_dict.ui.screens.top_navigation_bar.NavCloseIcon
import com.example.dune_dict.ui.screens.top_navigation_bar.NavMicrophoneIcon
import com.example.dune_dict.ui.screens.top_navigation_bar.NavSearchIcon
import com.example.dune_dict.util.Constants

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    searchViewModel: SearchViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val searchTextState by searchViewModel.searchTextState.collectAsState()
    val searchWidgetState by searchViewModel.searchWidgetState.collectAsState()
    val searchQueryListState by searchViewModel.searchQueryListState.collectAsState()

    Column {
        NavSearchBar(
            searchTextState = searchTextState,
            searchWidgetState = searchWidgetState,
            searchQueryListState = searchQueryListState,
            onTextChange = { word ->
                searchViewModel.updateSearchTextState(word)
                searchViewModel.getWordsByQuery(word)
            },
            onClicked = {
                searchViewModel.updateSearchWidgetState(SearchWidgetState.OPENED)
            },
            onDeleteBeforeClose = { word ->
                searchViewModel.onDeleteBeforeCloseWidget(word)
            },
            navController = navController
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
    navController: NavController
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
            label = { Text(
                text = stringResource(R.string.search_text),
                style = MaterialTheme.typography.body2
            ) },
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
            shape = RoundedCornerShape(Constants.VERY_HIGH_PADDING),
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
                searchQueryListState = searchQueryListState,
                navController = navController
            )
        }
    }

}

