package com.example.phinui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phinui.ui.theme.PhinUITheme
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.DateRange

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

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = BeigeBackground,
        bottomBar = {
            CustomBottomBar(
                currentDestination = currentDestination,
                onDestinationSelected = { currentDestination = it }
            )
        }
    ) { innerPadding ->
        ScreenContent(
            modifier = Modifier.padding(innerPadding),
            currentDestination = currentDestination
        )
    }
}

@Composable
fun ScreenContent(
    modifier: Modifier = Modifier,
    currentDestination: AppDestinations
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BeigeBackground)
    ) {

        // Show header only on Home
        if (currentDestination == AppDestinations.HOME) {
            TopHeader()
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(BeigeBackground),
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
                                onClick = { /* TODO Map */ }
                            )

                            HomeActionItem(
                                icon = Icons.Default.DateRange,
                                label = "Calendar",
                                onClick = { /* TODO Calendar */ }
                            )
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(60.dp)
                        ) {
                            HomeActionItem(
                                icon = Icons.Default.Schedule,
                                label = "Schedule",
                                onClick = { /* TODO Schedule */ }
                            )

                            HomeActionItem(
                                icon = Icons.Default.Event,
                                label = "Events",
                                onClick = { /* TODO Events */ }
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

@Composable
fun HomeActionItem(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = NavText,
            modifier = Modifier.size(48.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = label,
            fontSize = 20.sp,
            color = NavText,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun TopHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(145.dp)
            .background(HeaderRed),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Channel Islands",
                color = HeaderText,
                fontSize = 46.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "CSU",
                color = HeaderText,
                fontSize = 22.sp,
                fontWeight = FontWeight.Light
            )
        }
    }

}

@Composable
fun CustomBottomBar(
    currentDestination: AppDestinations,
    onDestinationSelected: (AppDestinations) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(BeigeBackground)
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
                tint = Color.Black,
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

enum class AppDestinations(
    val label: String,
    val icon: ImageVector,
) {
    HOME("Home", Icons.Default.Home),
    FAVORITES("Favorites", Icons.Default.Favorite),
    PROFILE("Profile", Icons.Default.AccountBox),
}

private val HeaderRed = Color(0xFFCB142A)
private val BeigeBackground = Color(0xFFFCFBF4)
private val HeaderText = Color(0xFFFCFBF4)
private val SelectedPill = Color(0x40CB142A)
private val NavText = Color(0xFF000000)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PhinUIAppPreview() {
    PhinUITheme {
        PhinUIApp()
    }
}