package com.rubylearner.scoped.noteapplication.feature.note.presentation.viewmodel

import androidx.paging.PagingSource
import com.rubylearner.scoped.noteapplication.feature.note.data.mapper.toModel
import com.rubylearner.scoped.noteapplication.feature.note.data.model.Note
import com.rubylearner.scoped.noteapplication.feature.note.data.repository.FakeRepository
import com.rubylearner.scoped.noteapplication.feature.note.domain.entity.NoteEntity
import com.rubylearner.scoped.noteapplication.feature.note.domain.repository.NoteRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class NoteViewModelTest {
    private lateinit var noteRepository : NoteRepository
    private  var list = mutableListOf(Note(id = 1, note = "Note 1", color = 200))
    @Before
    fun setUp() {
       noteRepository = FakeRepository()
    }


    @Test
    fun getData() = runBlocking{
       testFunction()
    }

    @Test
    fun setNote() = runBlocking{
        val noteEntity = NoteEntity(id = 2, note = "Note 2", color = 200)
        list.add(noteEntity.toModel())
        noteRepository.insert(noteEntity)
        testFunction()

    }

    @Test
    fun deleteNote() = runBlocking{
       /* val noteEntity = NoteEntity(id = 1, note = "Note 1", color = 200)
        list.remove(noteEntity.toModel())
        noteRepository.delete(noteEntity)
        testFunction()*/
    }

    @Test
    fun editNote() = runBlocking {
        val noteEntity = NoteEntity(id = 2, note = "Note 2", color = 200)
        list.find { it.id == 2 }?.apply {
            note = "Note Edited"
            color = 300
        }
        noteRepository.update(NoteEntity(id = 2, note = "Note Edited",300))
    }
    private suspend fun testFunction(){
        val actual = noteRepository.getAllNotes().load(
            PagingSource.LoadParams.Refresh(
                key = null,
                loadSize = list.size,
                placeholdersEnabled = false
            )
        )

        val expected = PagingSource.LoadResult.Page(
            data = list,
            prevKey = list.firstOrNull()?.id,
            nextKey = list.lastOrNull()?.id
        )
        assertEquals(actual,expected)
    }
}