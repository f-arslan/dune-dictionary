package com.example.dune_dict.data

import androidx.room.Dao
import androidx.room.Query
import com.example.dune_dict.data.models.Word
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {

    @Query("SELECT * FROM dune_dict ORDER BY RANDOM() LIMIT 30")
    fun getRandomWords(): Flow<List<Word>>

}