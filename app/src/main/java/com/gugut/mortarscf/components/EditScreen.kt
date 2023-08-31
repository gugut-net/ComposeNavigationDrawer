package com.gugut.mortarscf.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.gugut.mortarscf.R
import com.gugut.mortarscf.drawer.TopBar
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@Composable
fun EditScreen(
    openDrawer: () -> Unit,
    navController: NavHostController,
    savedData: DataViewModel
) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            title = "Second",
            buttonIcon = Icons.Filled.Menu,
            onButtonClicked = { openDrawer() },
            onMoreIconClicked = { openDrawer() }
        )
        Column(
//            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EditableTextFields(navController, viewModel())
        }
    }
}

@HiltViewModel
class DataViewModel @Inject constructor(

) : ViewModel() {
    var textValue by mutableStateOf("")
    var selectedDropdownItem by mutableStateOf("")
    var savedData by mutableStateOf("")
    var enteredData by mutableStateOf("")
}

@Composable
fun EditableTextFields(
    navController: NavHostController,
    sharedViewModel: DataViewModel
) {
    var textValue by remember { mutableStateOf("") }
    var selectedDropdownItem by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val dataViewModel: DataViewModel = viewModel()


    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)
        ) {
            TextField(
                value = selectedDropdownItem,
                onValueChange = { newDropdownItem ->
                    selectedDropdownItem = newDropdownItem
                },
                label = { Text("Select unit") },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = true },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = stringResource(id = R.string.cd_toggle_drawer)
                    )
                }
            )
            if (expanded) {
                DropdownMenu(
                    expanded = true,
                    onDismissRequest = {
                        expanded = false
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .wrapContentHeight()
                            .verticalScroll(rememberScrollState())
                    ) {
                        DropdownMenuItem(
                            onClick = {
                                selectedDropdownItem = "Settings"
                                expanded = false
                            },
                        ) {
                            Text(text = "Settings")
                        }
                        DropdownMenuItem(
                            onClick = {
                                selectedDropdownItem = "Help"
                                expanded = false
                            },
                        ) {
                            Text(text = "Help")
                        }
                        DropdownMenuItem(
                            onClick = {
                                selectedDropdownItem = "Contact"
                                expanded = false
                            },
                        ) {
                            Text(text = "Contact")
                        }
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)
        ) {
            TextField(
                value = textValue,
                onValueChange = { newText ->
                    textValue = newText
                },
                label = { Text("Enter something") },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable {
                    // Add your click handling logic here
                    navController.navigate("radio")
                },
            elevation = 8.dp
        ) {
            // Content of the Card goes here
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .height(150.dp) // Adjust the height value as needed
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                // Add your content here
            }
        }
    }
    Button(
        onClick = {
            // Save the entered data to the shared ViewModel
            sharedViewModel.enteredData = textValue

            // Pass the data back to HomeScreen using savedStateHandle
            navController.previousBackStackEntry
                ?.savedStateHandle
                ?.set("key", textValue)

            // Navigate back to the HomeScreen
            navController.popBackStack()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = "Save")
    }

}