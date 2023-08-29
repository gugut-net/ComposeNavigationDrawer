package com.gugut.mortarscf.drawer

import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun SettingsMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    onMenuItemClick: () -> Unit
) {
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = {
            onDismissRequest.invoke()
        }
    ) {
        DropdownMenuItem(
            onClick = {
                onMenuItemClick.invoke()
            }
        ) {
            Text(text = "Settings")
        }
        DropdownMenuItem(
            onClick = {
                onMenuItemClick.invoke()
            }
        ) {
            Text(text = "Help")
        }
        DropdownMenuItem(
            onClick = {
                onMenuItemClick.invoke()
            }
        ) {
            Text(text = "Contact")
        }
    }
}
