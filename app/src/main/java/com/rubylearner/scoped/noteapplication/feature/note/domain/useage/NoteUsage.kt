package com.rubylearner.scoped.noteapplication.feature.note.domain.useage

import com.rubylearner.scoped.noteapplication.feature.note.domain.entity.NoteEntity
import com.rubylearner.scoped.noteapplication.feature.note.domain.repository.NoteRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteUsage @Inject constructor(private val noteRepository: NoteRepository) {
    fun getAllNote() = noteRepository.getAllNotes()
    suspend fun insertNote(noteEntity: NoteEntity) = noteRepository.insert(noteEntity)

    suspend fun updateNote(noteEntity: NoteEntity) = noteRepository.update(noteEntity)

    suspend fun deleteNote(noteEntity: NoteEntity) = noteRepository.delete(noteEntity)
}