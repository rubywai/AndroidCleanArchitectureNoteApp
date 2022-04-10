package com.rubylearner.scoped.noteapplication.feature.note.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.rubylearner.scoped.cleanarchitecturetodolist.R
import com.rubylearner.scoped.cleanarchitecturetodolist.databinding.FragmentNoteAddBinding
import com.rubylearner.scoped.noteapplication.feature.note.presentation.viewmodel.NoteViewModel


class NoteAddFragment : Fragment() {
    private var _binding : FragmentNoteAddBinding? = null
    private val binding get() = _binding!!
    private val noteViewModel : NoteViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteAddBinding.inflate(inflater,container,false)
        binding.save.setOnClickListener {
            if(binding.edtNote.text.isEmpty()){
                Toast.makeText(context, "Please Enter Note", Toast.LENGTH_SHORT).show()
            }
            else{
                noteViewModel.setNote(binding.edtNote.text.toString().trim())
                findNavController().popBackStack()

            }
        }
        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}