package com.rubylearner.scoped.noteapplication.feature.note.presentation.view.acitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.rubylearner.scoped.cleanarchitecturetodolist.R
import com.rubylearner.scoped.cleanarchitecturetodolist.databinding.ActivityMainBinding
import com.rubylearner.scoped.noteapplication.feature.note.presentation.view.adapter.NoteListAdapter
import com.rubylearner.scoped.noteapplication.feature.note.presentation.viewmodel.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private  val noteViewModel : NoteViewModel by viewModels()
    private lateinit var mainBinding : ActivityMainBinding
    private lateinit var noteListAdapter: NoteListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        setUpUI()

    }
    private fun setUpUI(){
       mainBinding.todoRecycler.layoutManager = LinearLayoutManager(this)
        lifecycleScope.launchWhenStarted {
            noteViewModel.noteState.collect{
                noteListAdapter = NoteListAdapter(it)
                mainBinding.todoRecycler.adapter = noteListAdapter
            }
        }
        mainBinding.floatingActionButton.setOnClickListener {
            noteViewModel.setNote()
        }
    }
}