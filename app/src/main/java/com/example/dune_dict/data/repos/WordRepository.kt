package com.example.dune_dict.data.repos

import com.example.dune_dict.data.WordDao
import com.example.dune_dict.data.models.Word
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@ViewModelScoped
class WordRepository @Inject constructor(
    private val wordDao: WordDao
) {
    val getRandomWords: Flow<List<Word>> = wordDao.getRandomWords()

    fun getWordById(wordId: Int): Flow<Word> = wordDao.getWordById(wordId)
}