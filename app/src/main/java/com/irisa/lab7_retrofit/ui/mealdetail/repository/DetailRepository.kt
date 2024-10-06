package com.irisa.lab7_retrofit.ui.mealdetail.repository

import com.irisa.lab7_retrofit.networking.MealsWebService
import com.irisa.lab7_retrofit.networking.response.MealLook

class DetailRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMealsLook(id: String): MealLook?{
        return webService.getMealsLook(id).meals.firstOrNull()
    }
}
