package com.example.dune_dict.ui.screens.top_navigation_bar

import com.example.dune_dict.data.repos.WordRepository
import com.example.dune_dict.ui.screens.DuneDictViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject


@HiltViewModel
class TopNavigationViewModel @Inject constructor(
    private val wordRepository: WordRepository
) : DuneDictViewModel() {

    var searchTextState = MutableStateFlow("")
        private set

    var searchWidgetState = MutableStateFlow(SearchWidgetState.CLOSED)
        private set

    fun updateSearchTextState(newValue: String) {
        searchTextState.value = newValue
    }

    fun updateSearchWidgetState(newSearchWidgetState: SearchWidgetState) {
        searchWidgetState.value = newSearchWidgetState
    }

    fun onDeleteBeforeCloseWidget(word: String) {
        if (word.isNotEmpty()) {
            searchTextState.value = ""
        } else {
            searchWidgetState.value = SearchWidgetState.CLOSED
        }
    }


}