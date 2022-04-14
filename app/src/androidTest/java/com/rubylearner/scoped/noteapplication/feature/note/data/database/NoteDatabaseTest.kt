package com.rubylearner.scoped.noteapplication.feature.note.data.database

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rubylearner.scoped.noteapplication.feature.note.data.model.Note
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class NoteDatabaseTest : TestCase() {
    private lateinit var noteDatabase: NoteDatabase
    private lateinit var noteDao: NoteDao
    @Before
    public  fun setUpDb() {
        super.setUp()
        noteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            NoteDatabase::class.java
        ).build()
        noteDao = noteDatabase.getDao()

    }

    public override fun tearDown() {
        noteDatabase.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeUserAndReadNote() = runBlocking {
        val note: Note = Note(id = 1, note = "Testing Note", color = 200)
        noteDao.insert(note)
        val notes = noteDao.getNotes()
        assertEquals(notes.contains(note),true)

    }
}