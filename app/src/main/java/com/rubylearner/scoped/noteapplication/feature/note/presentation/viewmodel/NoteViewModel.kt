package com.rubylearner.scoped.noteapplication.feature.note.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.rubylearner.scoped.noteapplication.feature.note.data.mapper.toEntity
import com.rubylearner.scoped.noteapplication.feature.note.domain.entity.NoteEntity
import com.rubylearner.scoped.noteapplication.feature.note.domain.useage.NoteUsage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class NoteViewModel @Inject constructor(private val noteUseAge : NoteUsage) : ViewModel() {
    fun getData(): Flow<PagingData<NoteEntity>> {
        Log.d("database_debugging", "getData: called")
        return Pager(PagingConfig(20)) { noteUseAge.getAllNote() }
            .flow.cachedIn(viewModelScope)
            .map {
                it.map {
                    it.toEntity()
                }
            }
    }
    fun setNote(note : String){
        viewModelScope.launch {
            noteUseAge.insertNote(NoteEntity(note = note, color = 200))
        }

    }
    fun deleteNote(note : NoteEntity) {
        viewModelScope.launch {
            noteUseAge.deleteNote(note)
        }
    }
    fun editNote(note : NoteEntity){
        viewModelScope.launch {
            noteUseAge.updateNote(note)
        }
    }
}