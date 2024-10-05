package com.irisa.lab7_retrofit.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.*
import com.irisa.lab7_retrofit.ui.categories.view.Categories_Screen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationState.MealsCategories.route ) {
        composable(route = NavigationState.MealsCategories.route){
            Categories_Screen(navController)
        }
    }

}