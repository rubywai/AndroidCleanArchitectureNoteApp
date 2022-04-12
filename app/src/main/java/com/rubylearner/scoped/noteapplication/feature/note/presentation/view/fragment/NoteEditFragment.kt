package com.rubylearner.scoped.noteapplication.feature.note.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rubylearner.scoped.cleanarchitecturetodolist.R
import com.rubylearner.scoped.cleanarchitecturetodolist.databinding.FragmentNoteEditBinding

class NoteEditFragment : Fragment(R.layout.fragment_note_edit) {
    private var _fragmentNoteEditBinding :  FragmentNoteEditBinding? = null
    private val binding get() = _fragmentNoteEditBinding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _fragmentNoteEditBinding = FragmentNoteEditBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroyView() {
        _fragmentNoteEditBinding = null
        super.onDestroyView()
    }
}