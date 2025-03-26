package com.example.taskmanagercompose

sealed class Screen(val route: String, val title: String, val icon: Int) {
    object Home : Screen("home", "Home", R.drawable.home)
    object Calender : Screen("search", "Calender", R.drawable.calendar)
    object Profile : Screen("profile", "Profile", R.drawable.profile)
}