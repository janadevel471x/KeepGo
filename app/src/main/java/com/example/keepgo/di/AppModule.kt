package com.example.keepgo.di

import androidx.room.Room
import com.example.keepgo.data.NoteDataBase
import com.example.keepgo.data.NoteDataBaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNotesDao(noteDataBase: NoteDataBase): NoteDataBaseDao = noteDataBase.noteDao()

    @Singleton
    @Provides
    fun provideAppDataBase(@ApplicationContext context: android.content.Context): NoteDataBase =
        Room.databaseBuilder(
            context,
            NoteDataBase::class.java,
            "notes_db"
        )
            .fallbackToDestructiveMigration()
            .build()
}