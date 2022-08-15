package com.example.dune_dict.ui.screens.dict_all_words

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.dune_dict.data.models.Word
import com.example.dune_dict.data.repos.WordRepository
import com.example.dune_dict.ui.screens.DuneDictViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DictAllWordsViewModel @Inject constructor(
    private val wordRepository: WordRepository
) : DuneDictViewModel() {

    private val _allWords =
        MutableStateFlow<RequestState<List<Word>>>(RequestState.Idle)
    val allWords: StateFlow<RequestState<List<Word>>> = _allWords

    init {
        getAllWords()
    }

    private fun getAllWords() {
        _allWords.value = RequestState.Idle
        viewModelScope.launch {
            try {
                wordRepository.getAllWords.collect {
                    _allWords.value = RequestState.Success(it)
                }
            } catch (e: Exception) {
                _allWords.value = RequestState.Error(e)
            }
        }
    }

}