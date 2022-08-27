package com.example.dune_dict.ui.screens.home_screen

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.dune_dict.data.models.Word
import com.example.dune_dict.data.repos.WordRepository
import com.example.dune_dict.ui.screens.DuneDictViewModel
import com.example.dune_dict.ui.screens.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val wordRepository: WordRepository
) : DuneDictViewModel() {

    var homeWords = MutableStateFlow<RequestState<List<Word>>>(RequestState.Idle)
        private set

    init {
        getRandomWords()
        Log.d("HomeViewModel", "init")
    }

    private fun getRandomWords() {
        homeWords.value = RequestState.Idle
        viewModelScope.launch {
            try {
                wordRepository.getRandomWords.collect {
                    homeWords.value = RequestState.Success(it)
                }
            } catch (e: Exception) {
                homeWords.value = RequestState.Error(e)
            }
        }
    }

}