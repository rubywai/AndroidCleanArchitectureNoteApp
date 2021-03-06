package com.rubylearner.scoped.noteapplication.feature.note.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.rubylearner.scoped.cleanarchitecturetodolist.R
import com.rubylearner.scoped.cleanarchitecturetodolist.databinding.FragmentNoteEditBinding
import com.rubylearner.scoped.noteapplication.feature.note.domain.entity.NoteEntity
import com.rubylearner.scoped.noteapplication.feature.note.presentation.viewmodel.NoteViewModel

class NoteEditFragment : Fragment(R.layout.fragment_note_edit) {
    private val args : NoteEditFragmentArgs by navArgs()
    private var _fragmentNoteEditBinding :  FragmentNoteEditBinding? = null
    private val binding get() = _fragmentNoteEditBinding!!
    private val noteViewModel : NoteViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _fragmentNoteEditBinding = FragmentNoteEditBinding.inflate(inflater,container,false)
        binding.edtNote.setText(args.noteEntity.note)
        binding.btnEdit.setOnClickListener {
            noteViewModel.editNote(NoteEntity(id = args.noteEntity.id,note = binding.edtNote.text.toString(), color = 200))
            findNavController().popBackStack()
        }

        return binding.root
    }

    override fun onDestroyView() {
        _fragmentNoteEditBinding = null
        super.onDestroyView()
    }
}