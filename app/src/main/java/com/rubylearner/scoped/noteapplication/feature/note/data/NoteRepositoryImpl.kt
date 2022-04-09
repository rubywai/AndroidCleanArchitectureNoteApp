package com.rubylearner.scoped.noteapplication.feature.note.data

import android.content.Context
import com.rubylearner.scoped.noteapplication.feature.note.data.database.Note
import com.rubylearner.scoped.noteapplication.feature.note.data.database.NoteDao
import com.rubylearner.scoped.noteapplication.feature.note.data.database.NoteDatabase
import com.rubylearner.scoped.noteapplication.feature.note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(context: Context) : NoteRepository {
    private val noteDao : NoteDao = NoteDatabase.getNoteDatabase(context).getDao()
    override fun getAllNotes(): Flow<List<Note>> {
       return noteDao.getAllNote()
    }

    override suspend fun insert(note: Note) {
       noteDao.insert(note)
    }

    override suspend fun update(note: Note) {
        noteDao.update(note)
    }

    override suspend fun delete(note: Note) {
        noteDao.delete(note)
    }
}