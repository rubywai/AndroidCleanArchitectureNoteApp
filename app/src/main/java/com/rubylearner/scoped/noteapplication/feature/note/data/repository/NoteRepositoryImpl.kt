package com.rubylearner.scoped.noteapplication.feature.note.data.repository

import android.content.Context
import android.util.Log
import androidx.paging.PagingSource
import com.rubylearner.scoped.noteapplication.feature.note.data.database.NoteDao
import com.rubylearner.scoped.noteapplication.feature.note.data.database.NoteDatabase
import com.rubylearner.scoped.noteapplication.feature.note.domain.entity.NoteEntity
import com.rubylearner.scoped.noteapplication.feature.note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.map
import com.rubylearner.scoped.noteapplication.feature.note.data.mapper.toEntity
import com.rubylearner.scoped.noteapplication.feature.note.data.mapper.toModel
import com.rubylearner.scoped.noteapplication.feature.note.data.model.Note
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteRepositoryImpl @Inject constructor(private val noteDao: NoteDao) : NoteRepository {
    override fun getAllNotes(): PagingSource<Int, Note> {
       return noteDao.getAllNote()
    }


    override suspend fun insert(note: NoteEntity) {
        Log.d("DATABASEDEBUG", "insert: ")
        noteDao.insert(note.toModel())

    }

    override suspend fun update(note: NoteEntity) {
        noteDao.update(note.toModel())
    }

    override suspend fun delete(note: NoteEntity) {
        noteDao.delete(note.toModel())
    }
}