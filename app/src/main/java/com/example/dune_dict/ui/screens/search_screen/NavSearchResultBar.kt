package com.example.dune_dict.ui.screens.search_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import com.example.dune_dict.Screens
import com.example.dune_dict.data.models.SearchResultWord
import com.example.dune_dict.ui.screens.RequestState
import com.example.dune_dict.util.Constants.MEDIUM_PADDING

@Composable
fun NavSearchResultBar(
    modifier: Modifier = Modifier,
    searchQueryListState: RequestState<List<SearchResultWord>>,
    navController: NavController
) {
    when (searchQueryListState) {
        RequestState.Idle -> {}
        is RequestState.Success -> {
            NavSearchResultItems(
                searchQueryList = searchQueryListState.data,
                navController = navController
            )
        }
        is RequestState.Error -> {}
        else -> {}
    }
}


@Composable
private fun NavSearchResultItems(
    modifier: Modifier = Modifier,
    searchQueryList: List<SearchResultWord>,
    navController: NavController
) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = MEDIUM_PADDING, horizontal = MEDIUM_PADDING),
    ) {
        items(
            items = searchQueryList,
            key = { word ->
                word.id
            }
        ) { item ->
            NavSearchItem(
                searchQueryItem = item,
                navController = navController
            )
        }
    }
}

@Composable
private fun NavSearchItem(
    modifier: Modifier = Modifier,
    searchQueryItem: SearchResultWord,
    navController: NavController
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate(Screens.DetailWordScreen.passId(searchQueryItem.id))
            }
    ) {
        Text(
            text = searchQueryItem.term,
            style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Normal),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(MEDIUM_PADDING)

        )
    }
}








