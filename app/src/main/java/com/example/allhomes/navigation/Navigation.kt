package com.example.allhomes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.allhomes.model.PropertyResult
import com.example.allhomes.ui.dashboard.DashboardScreen
import com.example.allhomes.ui.dashboard.DashboardViewModel
import com.example.allhomes.ui.detail.DetailScreen
import com.example.allhomes.ui.welcome.WelcomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.WelcomeScreen.route){
        composable( route = Screen.WelcomeScreen.route){
            WelcomeScreen(navController = navController)
        }

        composable( route = Screen.DashboardScreen.route){
            DashboardScreen(navController = navController)
        }

        composable( route = Screen.DetailScreen.route){
            DetailScreen(navController = navController)
        }

    }
}