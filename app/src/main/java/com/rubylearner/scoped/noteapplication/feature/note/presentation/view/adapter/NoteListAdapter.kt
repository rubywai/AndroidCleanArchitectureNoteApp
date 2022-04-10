package com.rubylearner.scoped.noteapplication.feature.note.presentation.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rubylearner.scoped.cleanarchitecturetodolist.R
import com.rubylearner.scoped.cleanarchitecturetodolist.databinding.NoteLayoutBinding
import com.rubylearner.scoped.noteapplication.feature.note.domain.entity.NoteEntity

class NoteListAdapter(private val notes : List<NoteEntity>) :  RecyclerView.Adapter<NoteListAdapter.NoteViewHolder>(){
    class NoteViewHolder(view : NoteLayoutBinding) : RecyclerView.ViewHolder(view.root){
        var textView : TextView = view.txtNote
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = com.rubylearner.scoped.cleanarchitecturetodolist.databinding.NoteLayoutBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.textView.text = notes.get(position).note
    }

    override fun getItemCount(): Int = notes.size
}