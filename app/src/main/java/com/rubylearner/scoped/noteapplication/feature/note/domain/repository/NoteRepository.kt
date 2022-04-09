package com.rubylearner.scoped.noteapplication.feature.note.domain.repository

import com.rubylearner.scoped.noteapplication.feature.note.data.database.Note
import kotlinx.coroutines.flow.Flow


interface NoteRepository {
    fun getAllNotes() : Flow<List<Note>>
    suspend fun insert(note : Note)
    suspend fun update(note: Note)
    suspend fun delete(note: Note)

}