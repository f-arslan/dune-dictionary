package com.example.dune_dict.ui.screens.bottom_navigation_bar

import com.example.dune_dict.Screens
import com.example.dune_dict.ui.screens.DuneDictViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class BottomNavigationViewModel : DuneDictViewModel() {

    var currentPageState = MutableStateFlow<Screens>(Screens.HomeScreen)
        private set

    var currentPageTitleName = MutableStateFlow("")
        private set

    fun updateCurrentPageState(screens: Screens) {
        currentPageState.value = screens
        currentPageTitleName.value = ""
    }

    fun updateCurrentPageTitleName(title: String) {
        currentPageTitleName.value = title
    }
}