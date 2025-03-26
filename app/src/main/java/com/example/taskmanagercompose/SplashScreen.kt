package com.example.taskmanagercompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay


val righteousRegular = FontFamily(
    Font(R.font.righteous_regular),
)


@Composable
fun SplashScreen(onNavigate: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.white)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Add your splash screen logo or image

        Text(
            "TASK-WAN", style = TextStyle(
                color = colorResource(R.color.baseColor),
                fontSize = 26.sp, fontFamily = righteousRegular
            )
        )

        Spacer(modifier = Modifier.padding(4.dp))

        Image(
            painter = painterResource(id = R.drawable.splash_ic), // Replace with your logo
            contentDescription = "App Logo"
        )
    }

    // Navigate after a delay
    LaunchedEffect(Unit) {
        delay(2000) // 2 seconds delay
        onNavigate() // Navigate to the next screen
    }
}