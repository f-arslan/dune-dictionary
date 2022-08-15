package com.example.dune_dict.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dune_dict.util.Constants.DB_TABLE
import org.jetbrains.annotations.Nullable

@Entity(tableName = DB_TABLE)
data class Word(
    @PrimaryKey val id: Int,
    val term: String,
    val definition: String,
    val isChecked: Int,
)
