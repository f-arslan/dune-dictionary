package com.example.dune_dict

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.dune_dict.ui.screens.bottom_navigation_bar.BottomNavigationBar
import com.example.dune_dict.ui.screens.top_header.TopHeader
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
            val fabShape = AbsoluteCutCornerShape(50)
            Scaffold(
                topBar = {
                    TopHeader()
                },
                bottomBar = {
                    BottomNavigationBar(
                        navController = navController
                    )
                },
                floatingActionButtonPosition = FabPosition.Center,
                isFloatingActionButtonDocked = true,
                floatingActionButton = {
                    FloatingActionButton(
                        shape = fabShape,
                        onClick = {
                            navController.navigate(Screens.SearchScreen.route)
                        },
                        elevation = FloatingActionButtonDefaults.elevation(24.dp),
                        modifier = Modifier.size(64.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = stringResource(id = R.string.search_button),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
            ) { paddingValues ->
                DuneDictNavigation(navController = navController, paddingValues = paddingValues)
            }

        }
    }
}