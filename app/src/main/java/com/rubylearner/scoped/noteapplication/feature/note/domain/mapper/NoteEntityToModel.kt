package com.rubylearner.scoped.noteapplication.feature.note.data.mapper

import com.rubylearner.scoped.noteapplication.feature.note.data.model.Note
import com.rubylearner.scoped.noteapplication.feature.note.domain.entity.NoteEntity

fun NoteEntity.toModel() : Note {
    return Note(id = id,note = note,color = color)
}