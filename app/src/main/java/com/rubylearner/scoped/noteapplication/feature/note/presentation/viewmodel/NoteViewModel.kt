package com.rubylearner.scoped.noteapplication.feature.note.presentation.viewmodel

import android.app.Application
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import com.rubylearner.scoped.noteapplication.feature.note.data.model.Note
import com.rubylearner.scoped.noteapplication.feature.note.data.repository.NoteRepositoryImpl
import com.rubylearner.scoped.noteapplication.feature.note.domain.entity.NoteEntity
import com.rubylearner.scoped.noteapplication.feature.note.domain.repository.NoteRepository
import com.rubylearner.scoped.noteapplication.feature.note.domain.useage.NoteUsage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class NoteViewModel @Inject constructor(private val noteUseAge : NoteUsage) : ViewModel() {
    val noteState : MutableStateFlow<List<NoteEntity>> = MutableStateFlow(mutableListOf())
    init {
        getData()
    }
     private fun getData(){
        viewModelScope.launch(Dispatchers.IO) {
            noteUseAge.getAllNotes().collect{
                noteState.value = it
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