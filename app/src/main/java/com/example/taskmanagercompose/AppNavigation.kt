package com.example.taskmanagercompose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen {
                // Navigate to onboarding or main screen
                navController.navigate("onboarding") {
                    popUpTo("splash") { inclusive = true } // Remove splash screen from back stack
                }
            }
        }
        composable("onboarding") {
            OnboardingScreen {
                navController.navigate("main") {
                    popUpTo("onboarding") {
                        inclusive = true
                    }
                }
            }
        }
        composable("main") {
            MainScreen()
        }

    }
}