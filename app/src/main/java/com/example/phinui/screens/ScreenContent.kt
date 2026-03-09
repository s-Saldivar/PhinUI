package com.example.phinui.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.phinui.navigation.AppDestinations
import com.example.phinui.ui.components.TopHeader
import com.example.phinui.ui.theme.Background
import com.example.phinui.ui.theme.NavText
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.phinui.ui.theme.SelectedPill

@Composable
fun ScreenContent(
    modifier: Modifier = Modifier,
    currentDestination: AppDestinations,
    showEvents: Boolean,
    onOpenEvents: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Background)
    ) {
        if (currentDestination == AppDestinations.HOME && !showEvents) {
            TopHeader()
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Background)
                .padding(top = 24.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            if (showEvents) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Events",
                        fontSize = 28.sp,
                        color = NavText
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Column(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            //.background(SelectedPill)
                            .padding(20.dp)
                    ) {

                        Text(
                            text = "Health Science Advising Sessions",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = NavText
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Date: March 9\nTime: 9:00am",
                            fontSize = 16.sp,
                            color = NavText
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "Location: del Norte Hall 1500",
                            fontSize = 16.sp,
                            color = NavText
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    //event 2
                    Column(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            //.background(SelectedPill)
                            .padding(20.dp)
                    ) {

                        Text(
                            text = "Modoc Garden Work Days",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = NavText
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Date: March\nTime: 9:00am",
                            fontSize = 16.sp,
                            color = NavText
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "Location: Student Union Building 2021 - Meeting Room A",
                            fontSize = 16.sp,
                            color = NavText
                        )
                    }
                }
            } else {
                when (currentDestination) {
                    AppDestinations.HOME -> {
                        HomeDashboard(
                            onOpenEvents = onOpenEvents
                        )
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
}