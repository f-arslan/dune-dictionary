package com.example.dune_dict

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.dune_dict.ui.screens.detail_word_screen.DetailWordScreen
import com.example.dune_dict.ui.screens.home_screen.HomeScreen
import com.example.dune_dict.ui.screens.search_screen.SearchScreen

@Composable
fun DuneDictNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues,
    updateCurrentPageTitleName: (String) -> Unit,
    updateCurrentPageState: (Screens) -> Unit = {}
) {
    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route,
    ) {

        composable(Screens.HomeScreen.route) {
            HomeScreen(
                navController = navController,
                paddingValues = paddingValues,
                updateCurrentPageTitleName = updateCurrentPageTitleName
            )
        }
        composable(
            route = Screens.DetailWordScreen.route,
            arguments = listOf(
                navArgument(DETAIL_ARGUMENT_KEY) {
                    type = NavType.StringType
                }
            )
        ) {
            val id = it.arguments?.getString(DETAIL_ARGUMENT_KEY)?.toInt()!!
            DetailWordScreen(
                navController = navController,
                wordId = id,
                updateCurrentPageState = updateCurrentPageState
            )
        }
        composable(
            route = Screens.SearchScreen.route,
        ) {
            SearchScreen(
                navController = navController
            )
        }
    }
}
