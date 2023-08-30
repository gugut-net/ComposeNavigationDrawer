package com.gugut.mortarscf.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gugut.mortarscf.drawer.TopBar
import com.gugut.mortarscf.ui.theme.MortarsCFTheme

val LocalContext = compositionLocalOf<android.content.Context> { error("No Context provided") }

@Composable
fun RadioScreen(openDrawer: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            title = "Radio",
            buttonIcon = Icons.Filled.Menu,
            onButtonClicked = { openDrawer() },
            onMoreIconClicked = { openDrawer() }
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            SimpleRadioButtonComponent()
        }
    }
}

@Composable
fun SimpleRadioButtonComponent() {
    val radioOptions = listOf("DSA", "Java", "C++")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[2]) }

    var editText1Value by remember { mutableStateOf("") }
    var editText2Value by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            radioOptions.forEach { text ->
                Row(
                    Modifier
                        .selectable(
                            selected = (text == selectedOption),
                            onClick = { onOptionSelected(text) }
                        )
                ) {
                    RadioButton(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) },
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = text, modifier = Modifier.align(Alignment.CenterVertically))
                }
            }
        }

        when (selectedOption) {
            "DSA" -> {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextField(
                        value = editText1Value,
                        onValueChange = { editText1Value = it },
                        singleLine = true,
                        modifier = Modifier.weight(1f).padding()
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextField(
                        value = editText2Value,
                        onValueChange = { editText2Value = it },
                        singleLine = true,
                        modifier = Modifier.weight(1f).padding()
                    )
                }
            }
            "Java" -> {
                // Add content specific to the "Java" option
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextField(
                        value = editText2Value,
                        onValueChange = { editText2Value = it },
                        singleLine = true,
                        modifier = Modifier.weight(1f).padding()
                    )
                }
            }
            "C++" -> {
                // Add content specific to the "C++" option
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextField(
                        value = editText1Value,
                        onValueChange = { editText1Value = it },
                        singleLine = true,
                        modifier = Modifier.weight(1f).padding(),
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    )
                }
            }
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = editText1Value,
                onValueChange = { editText1Value = it },
                singleLine = true,
                modifier = Modifier.weight(1f).padding(),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
            )
        }
    }
}

//@Composable
//fun SimpleRadioButtonComponent() {
//    val radioOptions = listOf("DSA", "Java", "C++")
//    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[2]) }
//
//    var editText1Value by remember { mutableStateOf("") }
//    var editText2Value by remember { mutableStateOf("") }
//
//    Column(
//        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
//        verticalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        Row(
//            horizontalArrangement = Arrangement.spacedBy(8.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            radioOptions.forEach { text ->
//                Row(
//                    Modifier
//                        .selectable(
//                            selected = (text == selectedOption),
//                            onClick = { onOptionSelected(text) }
//                        )
//                ) {
//                    RadioButton(
//                        selected = (text == selectedOption),
//                        onClick = { onOptionSelected(text) },
//                        modifier = Modifier.align(Alignment.CenterVertically)
//                    )
//                    Spacer(modifier = Modifier.width(8.dp))
//                    Text(text = text, modifier = Modifier.align(Alignment.CenterVertically))
//                }
//            }
//        }
//
//        Row(
//            horizontalArrangement = Arrangement.spacedBy(8.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            TextField(
//                value = editText1Value,
//                onValueChange = { editText1Value = it },
//                singleLine = true,
//                modifier = Modifier.weight(1f).padding(end = 8.dp)
//            )
//            TextField(
//                value = editText2Value,
//                onValueChange = { editText2Value = it },
//                singleLine = true,
//                modifier = Modifier.weight(1f).padding(start = 8.dp)
//            )
//        }
//        Row(
//            horizontalArrangement = Arrangement.spacedBy(8.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            TextField(
//                value = editText1Value,
//                onValueChange = { editText1Value = it },
//                singleLine = true,
//                modifier = Modifier.weight(1f).padding()
//            )
//        }
//        Row(
//            horizontalArrangement = Arrangement.spacedBy(8.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            TextField(
//                value = editText1Value,
//                onValueChange = { editText1Value = it },
//                singleLine = true,
//                modifier = Modifier.weight(1f).padding()
//            )
//        }
//        Row(
//            horizontalArrangement = Arrangement.spacedBy(8.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            TextField(
//                value = editText1Value,
//                onValueChange = { editText1Value = it },
//                singleLine = true,
//                modifier = Modifier.weight(1f).padding(),
//                trailingIcon = {
//                    Icon(
//                        imageVector = Icons.Default.ArrowDropDown,
//                        contentDescription = null,
//                        modifier = Modifier.size(24.dp)
//                    )
//                }
//            )
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MortarsCFTheme {
        SimpleRadioButtonComponent()
    }
}