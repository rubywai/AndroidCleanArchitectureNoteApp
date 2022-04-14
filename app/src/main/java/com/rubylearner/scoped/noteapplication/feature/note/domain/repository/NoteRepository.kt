package com.rubylearner.scoped.noteapplication.feature.note.domain.repository

import androidx.paging.PagingSource
import com.rubylearner.scoped.noteapplication.feature.note.data.model.Note
import com.rubylearner.scoped.noteapplication.feature.note.domain.entity.NoteEntity
import dagger.Provides
import kotlinx.coroutines.flow.Flow


interface NoteRepository {
    fun getAllNotes() : PagingSource<Int, Note>
    suspend fun insert(note : NoteEntity)
    suspend fun update(note: NoteEntity)
    suspend fun delete(note: NoteEntity)

}