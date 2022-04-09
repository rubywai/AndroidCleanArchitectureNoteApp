package com.rubylearner.scoped.noteapplication.feature.note.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rubylearner.scoped.noteapplication.feature.note.data.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase  : RoomDatabase(){
    abstract  fun getDao() : NoteDao
}