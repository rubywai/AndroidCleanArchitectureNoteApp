package com.rubylearner.scoped.noteapplication.di

import android.content.Context
import androidx.room.Room
import com.rubylearner.scoped.noteapplication.feature.note.data.database.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {
    @Provides
    @Singleton
    fun getDb(@ApplicationContext context : Context) : NoteDatabase = Room.databaseBuilder(context, NoteDatabase::class.java,"notedb").build()

    @Provides
    @Singleton
    fun getDao(noteDb : NoteDatabase) = noteDb.getDao()

}