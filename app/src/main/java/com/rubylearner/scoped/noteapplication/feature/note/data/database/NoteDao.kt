package com.rubylearner.scoped.noteapplication.feature.note.data.database

import androidx.room.*
import com.rubylearner.scoped.noteapplication.feature.note.data.model.Note
import kotlinx.coroutines.flow.Flow


@Dao
interface  NoteDao {
    @Query("select * from note")
    fun getAllNote() : Flow<List<Note>>

    @Insert
    suspend fun insert(note : Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note : Note)

}