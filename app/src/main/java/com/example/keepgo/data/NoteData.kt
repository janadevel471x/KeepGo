package com.example.keepgo.data

import com.example.keepgo.model.Note

class NoteData {
    fun loadNotes(): List<Note> {
        return listOf(

            Note(
                title = "Note Title 1",
                description = "This is a description for Note 1."
            ),
            Note(
                title = "Note Title 2",
                description = "This is a description for Note 2."
            ),
            Note(
                title = "Note Title 3",
                description = "This is a description for Note 3."
            ),
            Note(
                title = "Note Title 4",
                description = "This is a description for Note 4."
            ),
            Note(
                title = "Note Title 5",
                description = "This is a description for Note 5."
            ),
            Note(
                title = "Note Title 6",
                description = "This is a description for Note 6."
            ),
            Note(
                title = "Note Title 7",
                description = "This is a description for Note 7."
            ),
            Note(
                title = "Note Title 8",
                description = "This is a description for Note 8."
            ),
            Note(
                title = "Note Title 9",
                description = "This is a description for Note 9."
            ),
            Note(
                title = "Note Title 10",
                description = "This is a description for Note 10."
            )
        )
    }
}