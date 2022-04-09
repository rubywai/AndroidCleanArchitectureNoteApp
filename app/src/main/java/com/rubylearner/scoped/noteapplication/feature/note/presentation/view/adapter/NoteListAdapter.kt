package com.rubylearner.scoped.noteapplication.feature.note.presentation.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rubylearner.scoped.cleanarchitecturetodolist.R
import com.rubylearner.scoped.noteapplication.feature.note.domain.entity.NoteEntity

class NoteListAdapter(private val notes : List<NoteEntity>) :  RecyclerView.Adapter<NoteListAdapter.NoteViewHolder>(){
    class NoteViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var textView : TextView = view.findViewById(R.id.txtNote)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_layout,parent,false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.textView.text = notes.get(position).note
    }

    override fun getItemCount(): Int = notes.size
}