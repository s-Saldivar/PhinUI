package com.example.phinui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phinui.navigation.AppDestinations
import com.example.phinui.ui.theme.Background
import com.example.phinui.ui.theme.NavText
import com.example.phinui.ui.theme.SelectedPill

@Composable
fun CustomBottomBar(
    currentDestination: AppDestinations,
    onDestinationSelected: (AppDestinations) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Background)
            .navigationBarsPadding()
            .padding(horizontal = 24.dp, vertical = 14.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppDestinations.entries.forEach { destination ->
            BottomBarItem(
                destination = destination,
                selected = destination == currentDestination,
                onClick = { onDestinationSelected(destination) }
            )
        }
    }
}

@Composable
fun BottomBarItem(
    destination: AppDestinations,
    selected: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(28.dp))
                .background(if (selected) SelectedPill else Color.Transparent)
                .clickable { onClick() }
                .padding(horizontal = 28.dp, vertical = 10.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = destination.icon,
                contentDescription = destination.label,
                tint = NavText,
                modifier = Modifier.size(34.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = destination.label,
            fontSize = 18.sp,
            color = NavText,
            fontWeight = FontWeight.Medium
        )
    }
}