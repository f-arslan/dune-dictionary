package com.example.dune_dict.ui.screens.home_screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.dune_dict.Screens
import com.example.dune_dict.data.models.Word
import com.example.dune_dict.ui.screens.RequestState

@Composable
fun HomeCardSection(
    modifier: Modifier = Modifier,
    navController: NavController,
    randomWords: RequestState<List<Word>>,
    paddingValues: PaddingValues,
    updateCurrentPageTitleName: (String) -> Unit
) {
    if (randomWords is RequestState.Success) {
        HomeCardList(
            randomWords = randomWords.data,
            navController = navController,
            paddingValues = paddingValues,
            updateCurrentPageTitleName = updateCurrentPageTitleName
        )
    }
}



