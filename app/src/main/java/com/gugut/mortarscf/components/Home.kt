package com.gugut.mortarscf.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.gugut.mortarscf.drawer.TopBar

@Composable
fun Home(
    openDrawer: () -> Unit,
    navController: NavHostController,
    sharedViewModel: DataViewModel,

    ) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            title = "Home",
            buttonIcon = Icons.Filled.Menu,
            onButtonClicked = { openDrawer() },
            onMoreIconClicked = { openDrawer() }
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate("second")
                }
                .padding(6.dp),
            elevation = 4.dp
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                // Observe the data using savedStateHandle
                val enteredData: String? = navController.currentBackStackEntry
                    ?.savedStateHandle
                    ?.get<String>("key")

                Text(
                    text = enteredData ?: "No data entered",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Card Description",
                    style = TextStyle(fontSize = 16.sp)
                )
            }
        }
    }
}