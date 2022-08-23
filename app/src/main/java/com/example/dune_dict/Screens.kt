package com.example.dune_dict

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SupervisedUserCircle
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.graphics.vector.ImageVector

const val DETAIL_ARGUMENT_KEY = "id"

sealed class Screens(val route: String, val icon: ImageVector) {
    // Top App Bar routes
    object DetailWordScreen : Screens("DetailWordScreen/{$DETAIL_ARGUMENT_KEY}", Icons.Rounded.DeviceThermostat) {
        fun passId(id: Int): String {
            return "DetailWordScreen/$id"
        }
    }
    // Bottom Navigation Bar routes
    object SearchScreen : Screens("SearchScreen", Icons.Rounded.Search)
    object ProfileScreen: Screens("ProfileScreen", Icons.Rounded.AccountCircle)
    object ReaperHomeScreen : Screens("ReaperHomeScreen", Icons.Rounded.Home)
    object HomeScreen : Screens("HomeScreen", Icons.Rounded.Stars)
}