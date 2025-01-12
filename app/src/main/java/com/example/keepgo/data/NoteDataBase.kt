package com.example.keepgo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.keepgo.model.Note
import com.example.keepgo.util.DateConverter
import com.example.keepgo.util.UUIDConverter

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(UUIDConverter::class, DateConverter::class)
abstract class NoteDataBase : RoomDatabase() {
    abstract fun noteDao():NoteDataBaseDao
}

