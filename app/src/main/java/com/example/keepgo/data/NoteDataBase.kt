package com.example.keepgo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.keepgo.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDataBase : RoomDatabase() {
    abstract fun noteDao():NoteDataBaseDao
}

