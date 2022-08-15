package com.example.dune_dict

import android.database.sqlite.SQLiteDatabase
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.dune_dict.ui.screens.dict_all_words.DictAllWordsViewModel
import com.example.dune_dict.ui.screens.dict_all_words.DuneCardItem
import com.example.dune_dict.ui.theme.DunedictTheme

@Composable
fun DuneDictApp(sharedViewModel: DictAllWordsViewModel) {

    DunedictTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            DuneCardItem(dictAllWordsViewModel = sharedViewModel)
        }
    }
}