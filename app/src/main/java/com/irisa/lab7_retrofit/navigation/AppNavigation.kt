package com.irisa.lab7_retrofit.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.irisa.lab7_retrofit.ui.categories.view.Categories_Screen
import com.irisa.lab7_retrofit.ui.mealdetail.view.Meal_Detail_Screen
import com.irisa.lab7_retrofit.ui.meals.view.Meals_Category_Screen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationState.MealsCategories.route ) {
        composable(route = NavigationState.MealsCategories.route){
            Categories_Screen(navController)
        }
        composable(NavigationState.MealsFilters.route,
            arguments = listOf(
                navArgument("category") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            val categoryName = arguments.getString("category") ?: ""
            Meals_Category_Screen(navController = navController, category = categoryName)
        }
        composable(NavigationState.MealsLook.route,
            arguments = listOf(
                navArgument("id") { type = NavType.StringType }
            )
        ){ backStackEntry ->
            val mealId = backStackEntry.arguments?.getString("id") ?: ""
            Meal_Detail_Screen(id = mealId, navController = navController)
        }
    }
}
