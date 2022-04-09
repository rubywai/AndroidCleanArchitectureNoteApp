package com.rubylearner.scoped.noteapplication.feature.note.data.model

import android.graphics.Color
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    val note : String,
    val color : Int
)