package com.rubylearner.scoped.noteapplication.feature.note.domain.repository

import com.rubylearner.scoped.noteapplication.feature.note.domain.entity.NoteEntity
import dagger.Provides
import kotlinx.coroutines.flow.Flow


interface NoteRepository {
    fun getAllNotes() : Flow<List<NoteEntity>>
    suspend fun insert(note : NoteEntity)
    suspend fun update(note: NoteEntity)
    suspend fun delete(note: NoteEntity)

}