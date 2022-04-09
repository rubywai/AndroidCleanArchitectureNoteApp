package com.rubylearner.scoped.noteapplication.feature.note.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase  : RoomDatabase(){
    abstract  fun getDao() : NoteDao
    companion object{
        @Volatile
        private var INSTANCE : NoteDatabase? = null
        fun getNoteDatabase(context : Context) : NoteDatabase {
            return INSTANCE ?: synchronized(this){
                val db = Room.databaseBuilder(context.applicationContext, NoteDatabase::class.java,"notedb").build()
                INSTANCE = db
                db
            }

        }
    }
}