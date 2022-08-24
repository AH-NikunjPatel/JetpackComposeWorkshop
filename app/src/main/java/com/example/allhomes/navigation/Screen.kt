package com.example.allhomes.navigation

enum class ScreenName(name: String){
    WELCOME("Welcome"),
    LOGIN("Login"),
    DASHBOARD("Dashboard"),
    DETAIL("Detail")
}
sealed class Screen(val route: String){
    object WelcomeScreen : Screen(ScreenName.WELCOME.name)
    object LoginScreen : Screen(ScreenName.LOGIN.name)
    object DashboardScreen : Screen(ScreenName.DASHBOARD.name)
    object DetailScreen : Screen(ScreenName.DETAIL.name)
}
