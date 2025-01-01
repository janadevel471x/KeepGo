package com.example.keepgo.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.keepgo.R
import com.example.keepgo.components.NoteButton
import com.example.keepgo.components.NoteInputField
import com.example.keepgo.model.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScree(
    notes:List<Note>,
    onAddNote:(Note) ->Unit,
    onRemoveNote: (Note) ->Unit
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
                    title = it
                })

            NoteInputField(
                modifier = Modifier
                    .padding(6.dp)
                    .fillMaxWidth(),
                text = description,
                lables = "Add a note",
                onTextChange = {
                    if(it.all { char ->
                        char.isLetter() || char.isWhitespace()
                        }) description = it
                })

            NoteButton(text = "save", enabled = true, onClick = {

            }, modifier = Modifier.padding(4.dp))
        }

    }
}

@Preview(showBackground = true)
@Composable
fun NotesScreenPreview() {
    NoteScree(notes = emptyList(), onRemoveNote = {}, onAddNote = {})
}