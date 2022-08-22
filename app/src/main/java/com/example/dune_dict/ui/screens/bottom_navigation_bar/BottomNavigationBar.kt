package com.example.dune_dict.ui.screens.bottom_navigation_bar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.dune_dict.Screens

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    BottomAppBar(
        cutoutShape = CircleShape
    ) {
        BottomNaves(
            navController = navController
        )
    }
}


@Composable
fun BottomNaves(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    // TODO: Add necessary parameter

    val routes = listOf(
        Screens.HomeScreen,
        Screens.RandomWordsScreen,
    )

    BottomNavigation {
        BottomNavigationItem(
            icon = {
                Icon(imageVector = routes[0].icon!!, contentDescription = "")
            },
            selected = false,
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(start = 8.dp)
        )
        BottomNavigationItem(
            icon = {
                Icon(imageVector = routes[1].icon!!, contentDescription = "")
            },
            selected = false,
            onClick = { /*TODO*/ },
        )
        BottomNavigationItem(
            icon = {
                Icon(imageVector = routes[1].icon!!, contentDescription = "")
            },
            selected = false,
            onClick = { /*TODO*/ },
        )
        BottomNavigationItem(
            icon = {},
            selected = false, onClick = { /*TODO*/ },
            enabled = false,
            modifier = Modifier.weight(1f)
        )
    }

}


@Composable
fun BottomNavHomeButton(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    contentDescription: String = ""
) {

}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
}