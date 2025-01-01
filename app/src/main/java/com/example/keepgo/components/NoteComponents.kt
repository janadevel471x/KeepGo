package com.example.keepgo.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.material3.Text as Text

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteInputField(
    modifier: Modifier = Modifier,
    text: String,
    lables: String,
    maxLine: Int = 1,
    onTextChange: (String) -> Unit,
    onImAction: () -> Unit = {}
) {
    val  keyboardController = LocalSoftwareKeyboardController.current
    TextField(modifier = modifier,
        value = text,
        onValueChange = onTextChange,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent
        ), label = {
            Text(text = lables)
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        maxLines = maxLine,
        keyboardActions = KeyboardActions(onDone = {
            onImAction()
            keyboardController?.hide()
        })
    )
}

@Composable
fun NoteButton(modifier: Modifier = Modifier,
               text: String?,
               onClick:() -> Unit,
               enabled: Boolean=true){

    Button(onClick = onClick,
        modifier = modifier,
        shape = CircleShape,
        enabled = enabled) {
        Text(text = text!!)
    }
}