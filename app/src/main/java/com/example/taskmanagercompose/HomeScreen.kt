package com.example.taskmanagercompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier


        ) {
            Row(
                modifier = Modifier
                    .weight(1F)
            ) {
                Text(
                    text = Utils.getCurrentDate(),
                    style = TextStyle(fontSize = 12.sp, fontFamily = poppinsRegular)
                )
            }
            Image(
                painter = painterResource(R.drawable.notification_ic),
                contentDescription = "Notification"
            )

        }
        Spacer(modifier = Modifier.padding(20.dp))
        Text(
            text = "Welcome Phillip",
            style = TextStyle(fontFamily = poppinsBold, fontSize = 24.sp)
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = "Have a nice day !",
            style = TextStyle(fontFamily = poppinsRegular, fontSize = 16.sp)
        )
        Spacer(modifier = Modifier.padding(15.dp))
        Text(
            text = "My Priority Task",
            style = TextStyle(fontFamily = poppinsSemiBold, fontSize = 20.sp)
        )

        LazyRow( horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            items(Utils.getList()) {
                TaskItem(it)
            }
        }
    }
}