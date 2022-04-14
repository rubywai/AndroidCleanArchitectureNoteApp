package com.rubylearner.scoped.noteapplication.feature.note.presentation.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.rubylearner.scoped.cleanarchitecturetodolist.R
import com.rubylearner.scoped.cleanarchitecturetodolist.databinding.NoteLayoutBinding
import com.rubylearner.scoped.noteapplication.feature.note.domain.entity.NoteEntity

class NoteListAdapter(
     private val onDelete: DeleteListener,
    private val onCardClick: CardClickListener
) : PagingDataAdapter<NoteEntity, NoteListAdapter.NoteViewHolder>(NoteDiffUtil()) {
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
        Log.d("paging_debugging", ": ${getItem(position)} ")
        getItem(position).let {
            val noteEntity = it
            holder.textView.text = it?.note
            holder.delete.setOnClickListener {
                noteEntity?.let {
                    onDelete.delete(it)
                }

            }
            holder.noteCard.setOnClickListener {
                noteEntity?.let {
                    onCardClick.onCardClick(it)
                }
            }
        }

    }

    class DeleteListener(val onDelete: (note: NoteEntity) -> Unit) {
        fun delete(note: NoteEntity) = onDelete(note)
    }

    class CardClickListener(val onClick: (note: NoteEntity) -> Unit) {
        fun onCardClick(note: NoteEntity) = onClick(note)
    }
    class NoteDiffUtil : DiffUtil.ItemCallback<NoteEntity>() {
        override fun areItemsTheSame(oldItem: NoteEntity, newItem: NoteEntity): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: NoteEntity, newItem: NoteEntity): Boolean = oldItem == newItem
    }
}