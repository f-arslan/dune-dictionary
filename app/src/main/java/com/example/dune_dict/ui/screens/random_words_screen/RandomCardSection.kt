package com.example.dune_dict.ui.screens.random_words_screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.dune_dict.data.models.Word
import com.example.dune_dict.ui.screens.RequestState

@Composable
fun RandomCardSection(
    modifier: Modifier = Modifier,
    navController: NavController,
    randomWords: RequestState<List<Word>>,
    paddingValues: PaddingValues,
) {
    if (randomWords is RequestState.Success) {
        RandomCardList(
            randomWords = randomWords.data,
            navController = navController,
            paddingValues = paddingValues
        )
    }
}



