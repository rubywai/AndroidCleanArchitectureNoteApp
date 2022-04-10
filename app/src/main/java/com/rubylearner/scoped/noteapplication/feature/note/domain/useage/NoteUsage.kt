package com.rubylearner.scoped.noteapplication.feature.note.domain.useage

import com.rubylearner.scoped.noteapplication.feature.note.data.model.Note
import com.rubylearner.scoped.noteapplication.feature.note.data.repository.NoteRepositoryImpl
import com.rubylearner.scoped.noteapplication.feature.note.domain.entity.NoteEntity
import com.rubylearner.scoped.noteapplication.feature.note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteUsage @Inject constructor(private val noteRepository: NoteRepository) {
    fun getAllNotes(): Flow<List<NoteEntity>> = noteRepository.getAllNotes()

    suspend fun insertNote(noteEntity: NoteEntity) = noteRepository.insert(noteEntity)

    suspend fun updateNote(noteEntity: NoteEntity) = noteRepository.update(noteEntity)

    suspend fun deleteNote(noteEntity: NoteEntity) = noteRepository.delete(noteEntity)
}