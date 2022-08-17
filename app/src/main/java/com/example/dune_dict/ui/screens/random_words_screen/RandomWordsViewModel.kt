package com.example.dune_dict.ui.screens.random_words_screen

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
class RandomWordsViewModel @Inject constructor(
    private val wordRepository: WordRepository
) : DuneDictViewModel() {

    var randomWords = MutableStateFlow<RequestState<List<Word>>>(RequestState.Idle)
        private set

    init {
        getRandomWords()
    }

    private fun getRandomWords() {
        randomWords.value = RequestState.Idle
        viewModelScope.launch {
            try {
                wordRepository.getRandomWords.collect {
                    randomWords.value = RequestState.Success(it)
                }
            } catch (e: Exception) {
                randomWords.value = RequestState.Error(e)
            }
        }
    }

}