package com.irisa.lab7_retrofit.ui.meals.repository

import com.irisa.lab7_retrofit.networking.MealsWebService
import com.irisa.lab7_retrofit.networking.response.*

class MealRepository(private val webService: MealsWebService = MealsWebService()) {

    suspend fun getMealsFilter(category: String): List<MealFilter>{
        return webService.getMealsFilter(category).meals
    }
}

