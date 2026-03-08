package com.example.phinui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phinui.navigation.AppDestinations
import com.example.phinui.components.HomeActionItem
import com.example.phinui.components.TopHeader
import com.example.phinui.ui.theme.Background
import com.example.phinui.ui.theme.NavText

@Composable
fun ScreenContent(
    modifier: Modifier = Modifier,
    currentDestination: AppDestinations
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Background)
    ) {
        if (currentDestination == AppDestinations.HOME) {
            TopHeader()
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Background),
            contentAlignment = Alignment.Center
        ) {
            when (currentDestination) {
                AppDestinations.HOME -> {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(40.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(60.dp)
                        ) {
                            HomeActionItem(
                                icon = Icons.Default.LocationOn,
                                label = "Map",
                                onClick = { }
                            )

                            HomeActionItem(
                                icon = Icons.Default.DateRange,
                                label = "Calendar",
                                onClick = { }
                            )
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(60.dp)
                        ) {
                            HomeActionItem(
                                icon = Icons.Default.Schedule,
                                label = "Schedule",
                                onClick = { }
                            )

                            HomeActionItem(
                                icon = Icons.Default.Event,
                                label = "Events",
                                onClick = { }
                            )
                        }
                    }
                }

                AppDestinations.FAVORITES -> {
                    Text(
                        text = "Favorites Screen",
                        fontSize = 24.sp,
                        color = NavText
                    )
                }

                AppDestinations.PROFILE -> {
                    Text(
                        text = "Profile Screen",
                        fontSize = 24.sp,
                        color = NavText
                    )
                }
            }
        }
    }
}