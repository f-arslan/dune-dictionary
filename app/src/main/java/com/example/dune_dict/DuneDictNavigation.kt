package com.example.dune_dict

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.dune_dict.ui.screens.detail_word_screen.DetailWordScreen
import com.example.dune_dict.ui.screens.random_words_screen.RandomWordsScreen

@Composable
fun DuneDictNavigation(
    navController: NavHostController,
    paddingValues: PaddingValues,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.RandomWordsScreen.route,
    ) {

        composable(Screens.RandomWordsScreen.route) {
            RandomWordsScreen(
                navController = navController,
                paddingValues = paddingValues
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
            Log.d("Navigation", id.toString())
            DetailWordScreen(
                navController = navController,
                wordId = id
            )
        }
    }
}