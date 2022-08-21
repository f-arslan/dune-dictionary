package com.example.dune_dict.ui.screens.detail_word_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.dune_dict.data.models.Word
import com.example.dune_dict.ui.screens.RequestState


@Composable
fun DetailWordScreen(
    wordId: Int,
    detailWordViewModel: DetailWordViewModel = hiltViewModel(),
    navController: NavController
) {
    val selectedWord by detailWordViewModel.selectedWord.collectAsState()
    LaunchedEffect(key1 = wordId) {
        // That's mean if the compose need to recompose, that's LaunchedEffect
        // not gonna recompose
        detailWordViewModel.getSelectedWordById(wordId)
    }

    when (selectedWord) {
        is RequestState.Success -> {
            val word = (selectedWord as RequestState.Success<Word>).data
            DetailWordSection(
                word = word
            )
        }
        else -> {}
    }
}


@Composable
fun DetailWordSection(word: Word) {
    Column {
        Text(text = word.term)
    }
}


