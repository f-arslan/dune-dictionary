package com.example.dune_dict

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SupervisedUserCircle
import androidx.compose.material.icons.rounded.AddCard
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.ui.graphics.vector.ImageVector

const val DETAIL_ARGUMENT_KEY = "id"

sealed class Screens(val route: String, val icon: ImageVector? = null) {
    // Top App Bar routes
    object DetailWordScreen : Screens("DetailWordScreen/{$DETAIL_ARGUMENT_KEY}") {
        fun passId(id: Int): String {
            return "DetailWordScreen/$id"
        }
    }
    // Bottom Navigation Bar routes TODO: Change some icons
    object SearchScreen : Screens("SearchScreen", Icons.Rounded.Search)
    object ProfileScreen: Screens("ProfileScreen", Icons.Default.SupervisedUserCircle)
    object HomeScreen : Screens("HomeScreen", Icons.Rounded.Home)
    object RandomWordsScreen : Screens("RandomWordsScreen", Icons.Rounded.AddCard)
}