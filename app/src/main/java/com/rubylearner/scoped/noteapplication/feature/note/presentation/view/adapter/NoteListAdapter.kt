package com.rubylearner.scoped.noteapplication.feature.note.presentation.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.rubylearner.scoped.cleanarchitecturetodolist.R
import com.rubylearner.scoped.cleanarchitecturetodolist.databinding.NoteLayoutBinding
import com.rubylearner.scoped.noteapplication.feature.note.domain.entity.NoteEntity

class NoteListAdapter(
    private val notes: List<NoteEntity>, private val onDelete: DeleteListener,
    private val onCardClick: CardClickListener
) : RecyclerView.Adapter<NoteListAdapter.NoteViewHolder>() {
    class NoteViewHolder(view: NoteLayoutBinding) : RecyclerView.ViewHolder(view.root) {
        var textView: TextView = view.txtNote
        var delete: Button = view.delete
        var noteCard: CardView = view.noteCard
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = NoteLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.textView.text = notes.get(position).note
        holder.delete.setOnClickListener {
            onDelete.delete(notes.get(position))
        }
        holder.noteCard.setOnClickListener {
            onCardClick.onClick(notes.get(position))
        }

    }

    override fun getItemCount(): Int = notes.size

    class DeleteListener(val onDelete: (note: NoteEntity) -> Unit) {
        fun delete(note: NoteEntity) = onDelete(note)
    }

    class CardClickListener(val onClick: (note: NoteEntity) -> Unit) {
        fun onCardClick(note: NoteEntity) = onClick(note)
    }
}