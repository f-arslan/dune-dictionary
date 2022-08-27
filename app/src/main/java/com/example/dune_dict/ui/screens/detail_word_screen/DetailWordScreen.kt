package com.example.dune_dict.ui.screens.detail_word_screen

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.dune_dict.Screens
import com.example.dune_dict.data.models.Word
import com.example.dune_dict.ui.screens.RequestState
import com.example.dune_dict.ui.use_cases.textToSpeech
import com.example.dune_dict.util.Constants.MEDIUM_HIGH_PADDING


@Composable
fun DetailWordScreen(
    wordId: Int,
    detailWordViewModel: DetailWordViewModel = hiltViewModel(),
    navController: NavController,
    updateCurrentPageState: (Screens) -> Unit = {}
) {
    val selectedWord by detailWordViewModel.selectedWord.collectAsState()
    LaunchedEffect(key1 = wordId) {
        // That's mean if the compose need to recompose, that's LaunchedEffect
        // not gonna recompose
        detailWordViewModel.getSelectedWordById(wordId)
    }
    val volumeButtonState by detailWordViewModel.volumeButtonState.collectAsState()
    Log.d("DetailWordScreen", "volume state: $volumeButtonState")
    when (selectedWord) {
        is RequestState.Success -> {
            val word = (selectedWord as RequestState.Success<Word>).data
            DetailWordSection(
                word = word,
                navController = navController,
                updateCurrentPageState = updateCurrentPageState,
                onClickVolume = {
                    detailWordViewModel.updateVolumeButtonState()
                },
                volumeButtonState = volumeButtonState
            )
        }
        else -> {
            // TODO: Handle loading page state
        }
    }
}


@Composable
fun DetailWordSection(
    modifier: Modifier = Modifier,
    word: Word,
    navController: NavController,
    updateCurrentPageState: (Screens) -> Unit = {},
    onClickVolume: () -> Unit = {},
    onClickFavourite: () -> Unit = {},
    onClickCopy: () -> Unit = {},
    volumeButtonState: Boolean = true,
    favouriteButtonState: Boolean = true,
    copyButtonState: Boolean = true,
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MEDIUM_HIGH_PADDING),
    ) {

        DetailIconsTab(
            onClickVolume = onClickVolume,
            onClickFavourite = onClickFavourite,
            onClickCopy = onClickCopy,
            volumeButtonState = volumeButtonState,
            favouriteButtonState = favouriteButtonState,
            copyButtonState = copyButtonState
        )

        Text(
            text = word.definition,
            style = MaterialTheme.typography.body2.copy(
                fontSize = 17.sp,
                fontWeight = FontWeight.SemiBold
            )
        )

        if (!volumeButtonState) {
            // That's mean the button is pressed
            textToSpeech(
                definition = word.definition,
                onClickVolume = onClickVolume,
                context = LocalContext.current
            )
        }

        BackHandler(enabled = true) {
            // After pressing back button, we updated the state of the header
            updateCurrentPageState(Screens.HomeScreen)
            navController.navigate(Screens.HomeScreen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    }
}



