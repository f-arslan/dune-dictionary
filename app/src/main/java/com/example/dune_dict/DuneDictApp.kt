package com.example.dune_dict

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FindInPage
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.dune_dict.ui.screens.bottom_navigation_bar.BottomNavigationBar
import com.example.dune_dict.ui.screens.top_navigation_bar.TopBar
import com.example.dune_dict.ui.theme.DunedictTheme
import com.example.dune_dict.util.Constants.MEDIUM_PADDING

@Composable
fun DuneDictApp() {

    DunedictTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val navController = rememberNavController()
            Scaffold(
                topBar = {
                    TopBar()
                },
                bottomBar = {
                   BottomNavigationBar(
                       navController = navController
                   )
                },
                floatingActionButtonPosition = FabPosition.End,
                isFloatingActionButtonDocked = true,
                floatingActionButton = {
                    FloatingActionButton(
                        shape = CircleShape,
                        onClick = {
                            // TODO: Do route
                        },
                        modifier = Modifier.size(56.dp)
                        ) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Fill this",
                        ) // TODO: Update this field
                    }
                },
            ) { paddingValues ->
                DuneDictNavigation(navController = navController, paddingValues = paddingValues)
            }

        }
    }
}