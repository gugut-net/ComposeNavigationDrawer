package com.gugut.mortarscf.drawer

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun TopBar(
    title: String = "",
    buttonIcon: ImageVector,
    onButtonClicked: () -> Unit,
    onMoreIconClicked: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = {
            IconButton(onClick = { onButtonClicked() }) {
                Icon(buttonIcon, contentDescription = "")
            }
        },
        actions = {
            IconButton(onClick = { expanded = true }) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "")
            }
            SettingsMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                onMenuItemClick = {
                    // Handle menu item click here
                    expanded = false
                }
            )
        },
        backgroundColor = MaterialTheme.colors.primary
    )
}
