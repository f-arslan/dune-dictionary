package com.example.dune_dict.ui.screens.search_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.dune_dict.R
import com.example.dune_dict.data.models.SearchResultWord
import com.example.dune_dict.ui.screens.RequestState
import com.example.dune_dict.ui.theme.Bone
import com.example.dune_dict.util.Constants.HIGH_PADDING
import com.example.dune_dict.util.Constants.MEDIUM_PADDING

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
    searchTextState: String = "",
    searchWidgetState: SearchWidgetState = SearchWidgetState.CLOSED,
    searchQueryListState: RequestState<List<SearchResultWord>> = RequestState.Idle,
    onTextChange: (String) -> Unit = {},
    onClicked: () -> Unit = {},
    onDeleteBeforeClose: (String) -> Unit = {},
    navController: NavController = rememberNavController()
) {

    val localFocusManager = LocalFocusManager.current

    Column {
        OutlinedTextField(
            value = searchTextState,
            shape = RoundedCornerShape(HIGH_PADDING),
            modifier = Modifier
                .fillMaxWidth()
                .padding(MEDIUM_PADDING),
            onValueChange = {
                onTextChange(it)
                onClicked()
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.search_text),
                    style = MaterialTheme.typography.body2
                )
            },
            leadingIcon = { NavSearchIcon() },
            trailingIcon = {
                when (searchWidgetState) {
                    SearchWidgetState.CLOSED -> {
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
            colors = TextFieldDefaults.textFieldColors(
                focusedLabelColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedLabelColor = Color.Transparent,
                backgroundColor = Bone.copy(alpha = 0.8f)
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    localFocusManager.clearFocus()
                },
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


@Preview(showBackground = true)
@Composable
fun NavSearchBarPreview() {
    NavSearchBar()
}

