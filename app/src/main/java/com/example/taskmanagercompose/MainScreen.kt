package com.example.taskmanagercompose


import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun MainScreen(
) {

    val screens = listOf(
        Screen.Home,
        Screen.Calender,
        Screen.Profile
    )

    val selectedIcons = listOf(
        R.drawable.home_inactive_ic,
        R.drawable.calendar_inactive_ic,
        R.drawable.profile_inactive_ic
    )
    val unselectedIcons =
        listOf(
            R.drawable.home_active_ic,
            R.drawable.calendar_active_ic,
            R.drawable.profile_active_ic
        )

    var selectedItem by remember { mutableIntStateOf(0) }


    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = colorResource(R.color.white),
                modifier = Modifier
                    .windowInsetsPadding(
                        WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom)
                    )
                    .height(70.dp)
                    .background(colorResource(R.color.white)),
            ) {
                screens.forEachIndexed { index, screen ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                painterResource(if (selectedItem == index) selectedIcons[index] else unselectedIcons[index]),
                                contentDescription = null,
                                tint = if (selectedItem == index) colorResource(R.color.selectedColor) else colorResource(
                                    R.color.unselectedColor
                                )
                            )
                        },
                        selected = selectedItem == index,
                        onClick = {
                            selectedItem = index
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (selectedItem) {
                0 -> {
                    HomeScreen()
                }

                1 -> {
                    CalenderScreen()
                }

                2 -> {
                    ProfileScreen()
                }
            }
        }
    }


}