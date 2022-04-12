package com.rubylearner.scoped.noteapplication.feature.note.domain.entity


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NoteEntity(
    val id : Int?,
    val note : String,
    val color : Int
) : Parcelable