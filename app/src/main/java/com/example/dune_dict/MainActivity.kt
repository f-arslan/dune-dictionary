package com.example.dune_dict

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.dune_dict.ui.screens.dict_all_words.DictAllWordsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val dictAllWordsViewModel: DictAllWordsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { DuneDictApp(
            sharedViewModel = dictAllWordsViewModel
        ) }
    }
}