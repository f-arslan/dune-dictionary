package com.example.dune_dict

const val DETAIL_ARGUMENT_KEY = "id"

sealed class Screens(val route: String) {
    object RandomWordsScreen: Screens("RandomWordsScreen")
    object DetailWordScreen: Screens("DetailWordScreen/{$DETAIL_ARGUMENT_KEY}") {
        fun passId(id: Int): String {
            return "DetailWordScreen/$id"
        }
    }
}