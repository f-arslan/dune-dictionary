package com.example.dune_dict.ui.screens.top_navigation_bar

import androidx.lifecycle.viewModelScope
import com.example.dune_dict.data.models.SearchResultWord
import com.example.dune_dict.data.models.Word
import com.example.dune_dict.data.repos.WordRepository
import com.example.dune_dict.ui.screens.DuneDictViewModel
import com.example.dune_dict.ui.screens.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TopNavigationViewModel @Inject constructor(
    private val wordRepository: WordRepository
) : DuneDictViewModel() {

    var searchTextState = MutableStateFlow("")
        private set

    var searchWidgetState = MutableStateFlow(SearchWidgetState.CLOSED)
        private set

    var searchQueryListState = MutableStateFlow<RequestState<List<SearchResultWord>>>(RequestState.Idle)
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

    fun getWordsByQuery(query: String) {
        viewModelScope.launch {
            try {
                wordRepository.getWordsByQuery(query).collect {
                    searchQueryListState.value = RequestState.Success(it)
                }
            } catch (e: Exception) {
                searchQueryListState.value = RequestState.Error(e)
            }
        }
    }


}