package com.example.dune_dict.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dune_dict.data.models.Word

@Database(entities = [Word::class], version = 1, exportSchema = true)
abstract class WordDatabase: RoomDatabase() {
    abstract fun wordDao(): WordDao
}