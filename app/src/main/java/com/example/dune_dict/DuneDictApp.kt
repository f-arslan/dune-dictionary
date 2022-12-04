package com.example.dune_dict

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FabPosition
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.dune_dict.ui.components.DuneFloatingActionButton
import com.example.dune_dict.ui.screens.bottom_navigation_bar.BottomNavigationBar
import com.example.dune_dict.ui.screens.bottom_navigation_bar.BottomNavigationViewModel
import com.example.dune_dict.ui.screens.top_header.TopHeader
import com.example.dune_dict.ui.theme.DunedictTheme

@Composable
fun DuneDictApp(
    bottomNavigationViewModel: BottomNavigationViewModel = hiltViewModel()
) {
    val currentPageState by bottomNavigationViewModel.currentPageState.collectAsState()
    val currentPageTitleName by bottomNavigationViewModel.currentPageTitleName.collectAsState()

    DunedictTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val navController = rememberNavController()
            Scaffold(
                topBar = {
                    TopHeader(
                        currentPageState = currentPageState,
                        currentPageTitleName = currentPageTitleName
                    )
                },
                bottomBar = {
                    BottomNavigationBar(
                        navController = navController,
                        updateCurrentPageState = {
                            bottomNavigationViewModel.updateCurrentPageState(it)
                        },
                        currentPageState = currentPageState
                    )
                },
                floatingActionButtonPosition = FabPosition.Center,
                isFloatingActionButtonDocked = true,
                floatingActionButton = {
                    DuneFloatingActionButton(
                        onClick = {
                            navController.navigate(Screens.SearchScreen.route) {
                                launchSingleTop = true
                            }
                            bottomNavigationViewModel.updateCurrentPageState(Screens.SearchScreen)
                        }
                    )
                },
            ) { paddingValues ->
                DuneDictNavGraph(
                    navController = navController,
                    paddingValues = paddingValues,
                    updateCurrentPageTitleName = {
                        bottomNavigationViewModel.updateCurrentPageTitleName(it)
                    },
                    updateCurrentPageState = {
                        bottomNavigationViewModel.updateCurrentPageState(it)
                    }
                )
            }
        }
    }
}