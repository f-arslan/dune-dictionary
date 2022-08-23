package com.example.dune_dict.ui.screens.bottom_navigation_bar

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.dune_dict.Screens

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val fabShape = AbsoluteCutCornerShape(50)
    val routes = listOf(
        Screens.ReaperHomeScreen,
        Screens.HomeScreen,
        Screens.SearchScreen,
        Screens.ProfileScreen,
        Screens.DetailWordScreen
    )
    BottomAppBar(
        cutoutShape = fabShape,
        contentPadding = PaddingValues(0.dp)
        // backgroundColor = MaterialTheme.colors.primary.compositeOver(MaterialTheme.colors.primaryVariant)
    ) {
        BottomNaves(navController = navController, routes = routes)
    }
}


@Composable
fun BottomNaves(
    modifier: Modifier = Modifier,
    navController: NavController,
    routes: List<Screens>
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    // TODO: Add necessary parameter


    BottomNavigation {
        routes.forEachIndexed { index, screens ->
            if (index != 2) {
                BottomNavigationItem(
                    modifier = Modifier.weight(1f),
                    icon = {
                        Icon(
                            imageVector = screens.icon,
                            contentDescription = screens.icon.toString()
                        )
                    },
                    selected = false,
                    onClick = {},
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


@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
}