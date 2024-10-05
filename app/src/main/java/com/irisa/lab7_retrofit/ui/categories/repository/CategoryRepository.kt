package com.irisa.lab7_retrofit.ui.categories.repository
import com.irisa.lab7_retrofit.networking.MealsWebService
import com.irisa.lab7_retrofit.networking.response.MealCategory

class CategoryRepository(private val webService: MealsWebService = MealsWebService()) {

    suspend fun getMealsCategories(): List<MealCategory> {
        return webService.getMealsCategories().categories
    }
}