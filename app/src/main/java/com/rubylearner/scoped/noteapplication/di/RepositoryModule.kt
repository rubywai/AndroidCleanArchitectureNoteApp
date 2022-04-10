package com.rubylearner.scoped.noteapplication.di

import com.rubylearner.scoped.noteapplication.feature.note.data.repository.NoteRepositoryImpl
import com.rubylearner.scoped.noteapplication.feature.note.domain.repository.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindNoteRepository(
        noteRepositoryImpl: NoteRepositoryImpl
    ) : NoteRepository
}