package com.example.dune_dict.ui.screens.home_screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.dune_dict.Screens

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavController,
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    updateCurrentPageTitleName: (String) -> Unit
) {
    val homeWords = viewModel.homeWords.collectAsState()

        HomeCardSection(
            randomWords = homeWords.value,
            navController = navController,
            paddingValues = paddingValues,
            updateCurrentPageTitleName = updateCurrentPageTitleName
        )

}

