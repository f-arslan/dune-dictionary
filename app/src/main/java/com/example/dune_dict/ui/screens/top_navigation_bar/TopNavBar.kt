package com.example.dune_dict.ui.screens.top_navigation_bar

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dune_dict.data.models.SearchResultWord
import com.example.dune_dict.data.models.Word
import com.example.dune_dict.ui.screens.RequestState

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    topNavigationViewModel: TopNavigationViewModel = hiltViewModel()
) {
    val searchTextState by topNavigationViewModel.searchTextState.collectAsState()
    val searchWidgetState by topNavigationViewModel.searchWidgetState.collectAsState()
    val searchQueryListState by topNavigationViewModel.searchQueryListState.collectAsState()

    Column {
        TopNavigation(
            searchTextState = searchTextState,
            searchWidgetState = searchWidgetState,
            searchQueryListState = searchQueryListState,
            onTextChange = { word ->
                topNavigationViewModel.updateSearchTextState(word)
                topNavigationViewModel.getWordsByQuery(word)
            },
            onClicked = {
                topNavigationViewModel.updateSearchWidgetState(SearchWidgetState.OPENED)
            },
            onDeleteBeforeClose = { word ->
                topNavigationViewModel.onDeleteBeforeCloseWidget(word)
            }
        )
        TopNavButtons()
    }
}


@Composable
fun TopNavigation(
    modifier: Modifier = Modifier,
    searchTextState: String,
    searchWidgetState: SearchWidgetState,
    searchQueryListState: RequestState<List<SearchResultWord>>,
    onTextChange: (String) -> Unit,
    onClicked: () -> Unit = {},
    onDeleteBeforeClose: (String) -> Unit
) {
    TopNavHeader(
        searchTextState = searchTextState,
        searchWidgetState = searchWidgetState,
        searchQueryListState = searchQueryListState,
        onClicked = onClicked,
        onTextChange = onTextChange,
        onDeleteBeforeClose = onDeleteBeforeClose
    )
}

@Preview(showBackground = true)
@Composable
fun TopNavigationBarPreview() {
    TopBar()
}