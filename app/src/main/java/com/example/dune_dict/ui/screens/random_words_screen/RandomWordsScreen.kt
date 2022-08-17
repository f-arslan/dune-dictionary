package com.example.dune_dict.ui.screens.random_words_screen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.dune_dict.ui.screens.random_words_screen.top_navigation_bar.TopNavigationBar

@Composable
fun RandomWordsScreen(
    viewModel: RandomWordsViewModel = hiltViewModel(),
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val randomWords = viewModel.randomWords.collectAsState()

    Scaffold(topBar = {
        TopNavigationBar()
    }) { paddingValues ->
        RandomCardSection(
            randomWords = randomWords.value,
            navController = navController,
            paddingValues = paddingValues
        )
    }

}

