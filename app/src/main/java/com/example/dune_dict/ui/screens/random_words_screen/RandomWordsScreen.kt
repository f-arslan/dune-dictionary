package com.example.dune_dict.ui.screens.random_words_screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun RandomWordsScreen(
    viewModel: RandomWordsViewModel = hiltViewModel(),
    navController: NavController,
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues
) {
    val randomWords = viewModel.randomWords.collectAsState()

        RandomCardSection(
            randomWords = randomWords.value,
            navController = navController,
            paddingValues = paddingValues
        )

}

