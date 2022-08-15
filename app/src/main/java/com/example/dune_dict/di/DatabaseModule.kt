package com.example.dune_dict.di

import android.content.Context
import androidx.room.Room
import com.example.dune_dict.data.WordDao
import com.example.dune_dict.data.WordDatabase
import com.example.dune_dict.util.Constants.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): WordDatabase = Room.databaseBuilder(
        context,
        WordDatabase::class.java,
        DB_NAME
    ).createFromAsset("database/dune_dict.db").build()

    @Singleton
    @Provides
    fun provideDao(database: WordDatabase): WordDao = database.wordDao()
}