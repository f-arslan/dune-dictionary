package com.example.dune_dict.ui.screens.bottom_navigation_bar

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.dune_dict.Screens

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    currentPageState: Screens,
    updateCurrentPageState: (Screens) -> Unit
) {

    val fabShape = AbsoluteCutCornerShape(50)
    val routes = listOf(
        Screens.HomeScreen,
        Screens.FavouritesScreen,
        Screens.SearchScreen,
        Screens.ProfileScreen,
        Screens.DetailWordScreen
    )
    BottomAppBar(
        cutoutShape = fabShape,
        contentPadding = PaddingValues(0.dp)
    ) {
        BottomNaves(
            navController = navController,
            routes = routes,
            currentPageState = currentPageState,
            updateCurrentPageState = updateCurrentPageState
        )
    }
}

@Composable
fun BottomNaves(
    modifier: Modifier = Modifier,
    navController: NavController,
    routes: List<Screens>,
    currentPageState: Screens,
    updateCurrentPageState: (Screens) -> Unit = {}
) {

    BottomNavigation {
        routes.forEachIndexed { index, screens ->
            if (index != 2) {
                BottomNavigationItem(
                    modifier = Modifier.weight(1f),
                    icon = {
                        Icon(
                            imageVector = screens.icon,
                            contentDescription = screens.title
                        )
                    },
                    selected = currentPageState.route == screens.route,
                    unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
                    onClick = {
                        updateCurrentPageState(screens)
                        if (screens == Screens.HomeScreen) {
                            navController.navigate(Screens.HomeScreen.route) {
                                popUpTo(navController.graph.findStartDestination().id)
                                // With this we remove all unnecessary copies of the same screen
                                launchSingleTop = true
                            }
                        }
                    },
                )
            } else {
                BottomNavigationItem(
                    modifier = Modifier.weight(1f),
                    icon = {},
                    selected = false,
                    onClick = {},
                    enabled = false
                )
            }
        }
    }
}
