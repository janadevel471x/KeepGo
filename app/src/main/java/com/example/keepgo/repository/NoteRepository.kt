package com.example.keepgo.repository

import com.example.keepgo.data.NoteDataBaseDao
import com.example.keepgo.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDataBaseDao: NoteDataBaseDao) {

    suspend fun addNote(note: Note) = noteDataBaseDao.insert(note = note)
    suspend fun updateNote(note: Note) = noteDataBaseDao.update(note = note)
    suspend fun deleteNote(note: Note) = noteDataBaseDao.deleteNote(note = note)
    suspend fun deleteAll() = noteDataBaseDao.deleteAll()
     fun getAllNotes() : Flow<List<Note>> = noteDataBaseDao.getNotes().flowOn(Dispatchers.IO).conflate()

}