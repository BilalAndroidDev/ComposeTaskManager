package com.example.taskmanagercompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OnboardingPage(drawable: Int, drawableDes: String, title: String, desc: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 80.dp, start = 20.dp, end = 20.dp, bottom = 0.dp)
            .background(colorResource(R.color.white)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(drawable),
            contentDescription = drawableDes
        )

        Spacer(modifier = Modifier.padding(12.dp))

        Text(
            text = title, style = TextStyle(
                color = colorResource(R.color.black),
                fontSize = 16.sp, fontFamily = poppinsMedium
            ),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.padding(12.dp))

        Text(
            text = desc,
            modifier = Modifier.fillMaxSize(),
            style = TextStyle(
                color = colorResource(R.color.black),
                fontSize = 14.sp, fontFamily = poppinsRegular,

                )
        )
    }
}