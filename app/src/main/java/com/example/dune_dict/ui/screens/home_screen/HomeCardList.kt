package com.example.dune_dict.ui.screens.home_screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.dune_dict.data.models.Word

@Composable
fun HomeCardList(
    modifier: Modifier = Modifier,
    navController: NavController,
    randomWords: List<Word>,
    paddingValues: PaddingValues,
    updateCurrentPageTitleName: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.padding(paddingValues)
    ) {
        items(
            items = randomWords,
            key = { word ->
                word.id
            }
        ) { word ->
            HomeCardItem(
                word = word,
                navController = navController,
                updateCurrentPageTitleName = updateCurrentPageTitleName
            )
        }
    }
}
