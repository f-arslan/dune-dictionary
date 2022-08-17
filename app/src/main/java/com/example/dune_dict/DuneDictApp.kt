package com.example.dune_dict

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.dune_dict.ui.screens.random_words_screen.top_navigation_bar.TopNavigationBar
import com.example.dune_dict.ui.theme.DunedictTheme

@Composable
fun DuneDictApp() {

    DunedictTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val navController = rememberNavController()
            DuneDictNavigation(navController = navController)

        }
    }
}