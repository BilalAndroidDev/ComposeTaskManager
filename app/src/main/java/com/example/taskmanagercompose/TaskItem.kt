package com.example.taskmanagercompose

import android.graphics.Color
import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch


@Composable
fun TaskItem(task: TaskEntity) {
    Box(
        modifier = Modifier
            .background(
                color = colorResource(task.backgroundColor),
                shape = RoundedCornerShape(30.dp)
            )
            .width(180.dp) // Ensure the box takes the full width
            .height(250.dp) // Adjust height to make the layout more spacious
    ) {
        // Background Image
        Image(
            painter = painterResource(R.drawable.background_ic),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(), // Fills the entire box
            contentScale = ContentScale.Crop // Crop to match the size
        )

        // Content Column
        Column(
            modifier = Modifier
                .fillMaxSize() // Fills the Box
                .padding(15.dp),
            verticalArrangement = Arrangement.SpaceBetween // Space items evenly
        ) {
            // Top-right text (10 days)
            Text(
                text = task.day,
                style = TextStyle(
                    fontSize = 10.sp,
                    fontFamily = poppinsRegular,
                    color = colorResource(R.color.black) // Adjust color as needed
                ),
                modifier = Modifier
                    .align(Alignment.End) // Aligns text to the top-right corner
                    .background(
                        color = colorResource(R.color.white),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(7.dp, 3.dp, 7.dp, 3.dp)
            )

            // Centered Icon and Text
            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(task.taskIcon),
                    contentDescription = "UI Icon",
                    modifier = Modifier.size(30.dp) // Adjust icon size as needed
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = task.taskTitle,
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontFamily = poppinsSemiBold,
                        color = colorResource(R.color.white)
                    )
                )
            }

            // Bottom Progress Indicator and Labels
            Row(
                modifier = Modifier
                    .fillMaxWidth() // Full width for the progress section
                    .padding(top = 8.dp, bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Left: Progress Text
                Column {
                    Text(
                        text = "Progress",
                        style = TextStyle(
                            fontFamily = poppinsRegular,
                            fontSize = 13.sp,
                            color = colorResource(R.color.white)
                        )
                    )
                    Spacer(modifier = Modifier.padding(2.dp))
                    // Progress Bar
                    LinearProgressIndicator(
                        progress = task.progress, // 80% progress
                        color = colorResource(R.color.white),
                        trackColor = colorResource(R.color.sliderColor),
                        modifier = Modifier

                            .height(5.dp) // Adjust height of the progress bar
                    )
                    Spacer(modifier = Modifier.padding(2.dp))

                    // Right: Percentage Text
                    Text(
                        modifier = Modifier.align(Alignment.End),
                        text = "80%",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = poppinsSemiBold,
                            color = colorResource(R.color.white)
                        )
                    )
                }
            }
        }
    }
}
