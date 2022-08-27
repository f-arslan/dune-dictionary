package com.example.dune_dict.ui.screens.detail_word_screen

import android.speech.tts.TextToSpeech
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
class DetailWordViewModel @Inject constructor(
    private val wordRepository: WordRepository
) : DuneDictViewModel() {

    var selectedWord = MutableStateFlow<RequestState<Word>>(RequestState.Idle)
        private set

    var volumeButtonState = MutableStateFlow(true)
        private set


    fun getSelectedWordById(id: Int) {
        selectedWord.value = RequestState.Idle
        viewModelScope.launch {
            try {
                wordRepository.getWordById(id).collect {
                    selectedWord.value = RequestState.Success(it)
                }
            } catch (e: Exception) {
                selectedWord.value = RequestState.Error(e)
            }
        }
    }

    fun updateVolumeButtonState() {
        volumeButtonState.value = volumeButtonState.value != true
    }

}