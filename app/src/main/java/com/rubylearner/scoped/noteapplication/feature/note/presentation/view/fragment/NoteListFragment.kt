package com.rubylearner.scoped.noteapplication.feature.note.presentation.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rubylearner.scoped.cleanarchitecturetodolist.R
import com.rubylearner.scoped.cleanarchitecturetodolist.databinding.NoteListScreenBinding
import com.rubylearner.scoped.noteapplication.feature.note.presentation.view.adapter.NoteListAdapter
import com.rubylearner.scoped.noteapplication.feature.note.presentation.viewmodel.NoteViewModel
import kotlinx.coroutines.flow.collectLatest

class NoteListFragment : Fragment(R.layout.note_list_screen) {
    private var noteListScreenBinding: NoteListScreenBinding? = null
    private val binding get() = noteListScreenBinding!!
    private val noteViewModel: NoteViewModel by activityViewModels()
    private lateinit var noteListAdapter: NoteListAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        noteListScreenBinding = NoteListScreenBinding.inflate(layoutInflater, container, false)
        noteListAdapter = NoteListAdapter(
            NoteListAdapter.DeleteListener {
                noteViewModel.deleteNote(it)
            },
            NoteListAdapter.CardClickListener {
                val action =  NoteListFragmentDirections.actionNoteListFragmentToNoteEditFragment(it)
                findNavController().navigate(action)
            })
        binding.noteListRecycler.layoutManager = LinearLayoutManager(context)
        binding.noteListRecycler.adapter = noteListAdapter
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_noteListFragment_to_noteAddFragment)
        }
        lifecycleScope.launchWhenStarted {
            noteViewModel.getData().collectLatest {
                Log.d("database_debugging", "data getting: $it")
                 noteListAdapter.submitData(it)
            }
        }
        return binding.root
    }

    override fun onDestroy() {
        noteListScreenBinding = null
        super.onDestroy()
    }

}