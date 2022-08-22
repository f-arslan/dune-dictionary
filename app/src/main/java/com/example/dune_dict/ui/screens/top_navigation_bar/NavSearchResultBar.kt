package com.example.dune_dict.ui.screens.top_navigation_bar

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.dune_dict.data.models.SearchResultWord
import com.example.dune_dict.ui.screens.RequestState
import com.example.dune_dict.util.Constants.MEDIUM_PADDING

@Composable
fun NavSearchResultBar(
    modifier: Modifier = Modifier,
    searchQueryListState: RequestState<List<SearchResultWord>>,
) {
    when (searchQueryListState) {
        RequestState.Idle -> {}
        is RequestState.Success -> {
            NavSearchResultItems(
                searchQueryList = searchQueryListState.data
            )
        }
        is RequestState.Error -> {}
        else -> {}
    }
}


@Composable
private fun NavSearchResultItems(
    modifier: Modifier = Modifier,
    searchQueryList: List<SearchResultWord>
) {
    LazyColumn {
        items(
            items = searchQueryList,
            key = { word ->
                word.id
            }
        ) { item ->
            NavSearchItem(
                searchQueryItem = item
            )
        }
    }
}

@Composable
private fun NavSearchItem(
    modifier: Modifier = Modifier,
    searchQueryItem: SearchResultWord
) {
    val scrollableState = rememberScrollState()
    Text(
        text = searchQueryItem.term,
        style = MaterialTheme.typography.body1,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier
            .padding(MEDIUM_PADDING)
            .scrollable(
                state = scrollableState, orientation = Orientation.Vertical
            )
    )

}


@Preview(showBackground = true)
@Composable
private fun NavSearchItemPreview() {
    NavSearchItem(
        searchQueryItem = SearchResultWord(
            id = 4,
            term = "hello",
        )
    )
}






