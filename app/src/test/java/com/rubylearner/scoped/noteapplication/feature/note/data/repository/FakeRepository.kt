package com.rubylearner.scoped.noteapplication.feature.note.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.rubylearner.scoped.noteapplication.feature.note.data.mapper.toModel
import com.rubylearner.scoped.noteapplication.feature.note.data.model.Note
import com.rubylearner.scoped.noteapplication.feature.note.domain.entity.NoteEntity
import com.rubylearner.scoped.noteapplication.feature.note.domain.repository.NoteRepository
import java.io.IOException

class FakeRepository : NoteRepository {
    private val notes = mutableListOf(Note(id = 1, note = "Note 1", color = 200))
    private lateinit var  pagingSource : FakePagingSource
    override fun getAllNotes(): PagingSource<Int, Note> {
        pagingSource = FakePagingSource(notes)
            return pagingSource
    }

    override suspend fun insert(note: NoteEntity) {
        notes.add(note.toModel())
    }

    override suspend fun update(note: NoteEntity) {
        notes.find { it.id == note.id }?.apply {
            this.note = note.note
            this.color = note.color
        }
    }

    override suspend fun delete(note: NoteEntity) {
        note.id?.let { notes.removeAt(it) }
    }

    class FakePagingSource(private val items: List<Note>) : PagingSource<Int, Note>() {
        override fun getRefreshKey(state: PagingState<Int, Note>): Int? {
            return state.anchorPosition?.let { anchorPosition ->
                state.closestItemToPosition(anchorPosition)?.id
            }
        }

        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Note> {
            return try {

                LoadResult.Page(
                    data = items,
                    prevKey = items.firstOrNull()?.id,
                    nextKey = items.lastOrNull()?.id
                )
            } catch (e: IOException) {
                LoadResult.Error(e)
            }
        }

    }

}