package com.example.allhomes.ui.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun DetailScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Text(
            text = "Detail Screen")
    }

}