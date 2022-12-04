package com.example.dune_dict

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.graphics.vector.ImageVector

const val DETAIL_ARGUMENT_KEY = "id"

sealed class Screens(val route: String, val title: String, val icon: ImageVector) {
    // Top App Bar routes
    object DetailWordScreen : Screens(
        "DetailWordScreen/{$DETAIL_ARGUMENT_KEY}",
        "Detail",
        Icons.Rounded.DeviceThermostat
    ) {
        fun passId(id: Int): String {
            return "DetailWordScreen/$id"
        }
    }

    // Bottom Navigation Bar routes
    object HomeScreen : Screens("HomeScreen", "Home", Icons.Rounded.Home)
    object FavouritesScreen : Screens("FavouritesScreen", "Favourites", Icons.Rounded.Stars)
    object SearchScreen : Screens("SearchScreen", "Search", Icons.Rounded.Search)
    object ProfileScreen : Screens("ProfileScreen", "Profile", Icons.Rounded.AccountCircle)
}