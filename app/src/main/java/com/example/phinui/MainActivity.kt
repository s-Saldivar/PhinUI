package com.example.phinui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.example.phinui.navigation.AppDestinations
import com.example.phinui.ui.components.CustomBottomBar
import com.example.phinui.ui.screens.ScreenContent
import com.example.phinui.ui.theme.Background
import com.example.phinui.ui.theme.PhinUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PhinUITheme {
                PhinUIApp()
            }
        }
    }
}

@PreviewScreenSizes
@Composable
fun PhinUIApp() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }
    var showEvents by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Background,
        bottomBar = {
            CustomBottomBar(
                currentDestination = currentDestination,
                onDestinationSelected = {
                    currentDestination = it
                    showEvents = false
                }
            )
        }
    ) { innerPadding ->
        ScreenContent(
            modifier = Modifier.padding(innerPadding),
            currentDestination = currentDestination,
            showEvents = showEvents,
            onOpenEvents = { showEvents = true }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PhinUIAppPreview() {
    PhinUITheme {
        PhinUIApp()
    }
}