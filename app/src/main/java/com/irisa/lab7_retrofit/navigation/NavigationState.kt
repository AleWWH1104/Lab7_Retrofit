package com.irisa.lab7_retrofit.navigation

sealed class NavigationState(val route: String)  {
    data object MealsCategories: NavigationState("categories")

    data object MealsFilters: NavigationState("categories/{category}")  {
        fun createRoute(category: String) = "categories/$category"
    }

}
