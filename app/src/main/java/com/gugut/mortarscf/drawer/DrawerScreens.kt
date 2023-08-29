package com.gugut.mortarscf.drawer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DrawerScreens(
    val title: String,
    val route: String,
    val icon: ImageVector // Add this property for icons
) {
    object Home : DrawerScreens("Home", "home", Icons.Default.Home)
    object Units : DrawerScreens("Units", "units", Icons.Default.Info) // Replace with appropriate icon
    object Account : DrawerScreens("Account", "account", Icons.Default.AccountCircle) // Replace with appropriate icon
    object Help : DrawerScreens("Help", "help", Icons.Default.Warning)
    object Settings : DrawerScreens("Settings", "settings", Icons.Default.Settings)
    object Second : DrawerScreens("Second", "second", Icons.Default.Add) // Replace with appropriate icon
}


val screens = listOf(
    DrawerScreens.Home,
    DrawerScreens.Account,
    DrawerScreens.Help,
    DrawerScreens.Units,
    DrawerScreens.Settings,
    DrawerScreens.Second
)