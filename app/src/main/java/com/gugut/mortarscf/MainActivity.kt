package com.gugut.mortarscf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.gugut.mortarscf.components.MainScreen
import com.gugut.mortarscf.drawer.Drawer
import com.gugut.mortarscf.ui.theme.MortarsCFTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MortarsCFTheme {
                MainScreen()
            }
        }
    }
}

@Preview
@Composable
fun DrawerPreview() {
    MortarsCFTheme {
        Drawer(
            onDestinationClicked = {}
        )
    }
}
