package com.irisa.lab7_retrofit.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title: String, navController: NavController){
    TopAppBar(
        title = { Text(title)},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF56667A),  // Color de fondo del AppBar
            titleContentColor = Color.White  // Color del título
        )
    )
}