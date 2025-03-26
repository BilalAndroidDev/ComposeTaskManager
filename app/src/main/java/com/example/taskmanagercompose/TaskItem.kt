package com.example.taskmanagercompose

import android.graphics.Color
import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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

@Composable
fun TaskItem() {
    Box(
        modifier = Modifier.background(
            color = colorResource(R.color.baseColor),
            shape = RoundedCornerShape(15.dp)
        )
    ) {
        Image(
            painter = painterResource(R.drawable.background_ic),
            contentDescription = "Ui"
        )


        Column(modifier = Modifier.padding(10.dp)) {
            Text(
                text = "10 days",
                style = TextStyle(fontSize = 10.sp, fontFamily = poppinsRegular),
                modifier = Modifier
                    .background(
                        color = colorResource(R.color.white),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(7.dp, 3.dp, 7.dp, 3.dp)
                    .align(Alignment.End) // Aligns the text to the top-right corner
            )


            Row() {
                Image(painter = painterResource(R.drawable.ui_icon), contentDescription = "Uri")
                Spacer(modifier = Modifier.padding(5.dp))
                Text(
                    text = "UI Design",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = poppinsSemiBold,
                        color = colorResource(R.color.white)
                    )
                )
            }

            Text(
                text = "Progress",
                style = TextStyle(
                    fontFamily = poppinsRegular,
                    fontSize = 10.sp,
                    color = colorResource(R.color.white)
                )
            )

        }
    }
}