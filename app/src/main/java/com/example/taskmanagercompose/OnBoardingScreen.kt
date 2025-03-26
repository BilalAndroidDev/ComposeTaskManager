package com.example.taskmanagercompose

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

val poppinsMedium = FontFamily(
    Font(R.font.poppins_medium),
)

val poppinsRegular = FontFamily(
    Font(R.font.poppins_regular),
)

val poppinsBold = FontFamily(
    Font(R.font.poppins_bold),
)

val poppinsSemiBold = FontFamily(
    Font(R.font.poppins_semibold),
)

@Composable
fun OnboardingScreen(onFinish: () -> Unit) {

    val scope = rememberCoroutineScope()

    val pagerState = rememberPagerState { 3 }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.white)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BackHandler {
            Log.d("Onboarding", "OnboardingScreen: BackHandler")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth() // Fills the width of the screen
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .weight(1F)
            ) {
                repeat(3) { index ->
                    val color =
                        if (pagerState.currentPage == index) colorResource(R.color.baseColor) else colorResource(
                            R.color.greyColor
                        )
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(10.dp)
                            .background(color, shape = CircleShape)
                    )
                }
            }

            Text(
                text = "Skip",
                style = TextStyle(
                    color = colorResource(R.color.baseColor),
                    fontSize = 12.sp,
                    fontFamily = poppinsMedium
                ), modifier = Modifier.clickable {
                    // Action when "Skip" is clicked
                    Log.d("Onboarding", "Skip clicked")
                    onFinish.invoke()
                }
            )
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            when (page) {
                0 -> OnboardingPage(
                    drawable = R.drawable.onboarding1,
                    drawableDes = "First Description",
                    title = "Easy Time Management",
                    desc = "With management based on priority and daily tasks, it will give you convenience in managing and determining the tasks that must be done first"
                )

                1 -> OnboardingPage(
                    drawable = R.drawable.onboarding1,
                    drawableDes = "Second Description",
                    title = "Increase Work Effectiveness",
                    desc = "Time management and the determination of more important tasks will give your job statistics better and always improve"
                )

                2 -> OnboardingPage(
                    drawable = R.drawable.onboarding3,
                    drawableDes = "Third Description",
                    title = "Reminder Notification",
                    desc = "The advantage of this application is that it also provides reminders for you so you don't forget to keep doing your assignments well and according to the time you have set"
                )
            }
        }

        Button(
            onClick = {
                // Action when button is clicked
                Log.d("TESTCC", "OnboardingScreen: ")
                scope.launch {
                    when (pagerState.currentPage) {
                        0 -> {
                            pagerState.animateScrollToPage(1)
                        }

                        1 -> {
                            pagerState.animateScrollToPage(2)
                        }

                        2 -> {
                            onFinish.invoke()
                        }
                    }
                }
            },
            colors = ButtonColors(
                containerColor = colorResource(R.color.baseColor),
                contentColor = colorResource(R.color.white),
                disabledContainerColor = colorResource(R.color.baseColor),
                disabledContentColor = colorResource(R.color.white)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp) // Add padding to make the button look good
                .indication(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple()
                ) // Ripple effect

        ) {
            Text(
                text = "Get Started",
                style = TextStyle(
                    color = colorResource(R.color.white),
                    fontSize = 14.sp, fontFamily = poppinsMedium
                ),
                textAlign = TextAlign.Center,

                )
        }
    }
}