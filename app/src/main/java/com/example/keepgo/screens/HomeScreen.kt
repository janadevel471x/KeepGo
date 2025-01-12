package com.example.keepgo.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.keepgo.R
import com.example.keepgo.components.NoteButton
import com.example.keepgo.components.NoteInputField
import com.example.keepgo.data.NoteData
import com.example.keepgo.model.Note
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScree(
    note: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit
) {

    var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }


    Column(modifier = Modifier.padding(6.dp)) {

        TopAppBar(
            title = {
                Text(text = stringResource(R.string.app_name))
            },
            actions = {
                Icon(
                    imageVector = Icons.Rounded.Notifications,
                    contentDescription = "Icon"
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFDADFE3))
        )

        //content
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            NoteInputField(
                modifier = Modifier
                    .padding(6.dp)
                    .fillMaxWidth(),
                text = title,
                lables = "Title",
                onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) title = it
                })

            NoteInputField(
                modifier = Modifier
                    .padding(6.dp)
                    .fillMaxWidth(),
                text = description,
                lables = "Add a note",
                onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) description = it
                })

            NoteButton(text = "save", enabled = true, onClick = {

                if (title.isNotEmpty() && description.isNotEmpty()) {

                    onAddNote(Note(title = title,
                        description = description))
                    title = ""
                    description = ""
                }

            }, modifier = Modifier.padding(4.dp))
        }
        HorizontalDivider(modifier = Modifier.padding(10.dp))
        LazyColumn {
            items(note) { notes ->

                NoteRow(notes = notes, onNoteClicked = {
                    onRemoveNote(it)
                })

            }
        }
    }
}

@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    notes: Note,
    onNoteClicked: (Note) -> Unit
) {
    Surface(modifier.padding(4.dp)
        .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
        .fillMaxWidth(),
        color = Color(0xFFDFE6EB),
        tonalElevation = 6.dp) {

        Column(modifier.clickable {
            onNoteClicked(notes)
        }.padding(horizontal = 14.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.Start) {

            Text(text = notes.title,
                style = MaterialTheme.typography.titleSmall)
            Text(text = notes.description, style = MaterialTheme.typography.titleSmall)
//            Text(text = notes.entryDate.format(DateTimeFormatter.ofPattern("EEE, d, MMM")),
//                style = MaterialTheme.typography.labelLarge)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotesScreenPreview() {
    NoteScree(note = NoteData().loadNotes(), onRemoveNote = {}, onAddNote = {})
}