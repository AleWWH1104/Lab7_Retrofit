package com.irisa.lab7_retrofit.networking.response

import com.google.gson.annotations.SerializedName

data class CategoryResponse(val categories: List<MealCategory>)
data class FilterResponse(val meals: List<MealFilter>)
data class LookResponse(val meals: List<MealLook>)

data class MealCategory(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val category: String,
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageUrl: String
)

data class MealFilter(
    @SerializedName("idMeal") val id: String,
    @SerializedName("strMeal") val name: String,
    @SerializedName("strMealThumb") val imageUrl: String
)

data class MealLook(
    @SerializedName("strCategory") val category: String,
    @SerializedName("strMeal") val name: String,
    @SerializedName("strMealThumb") val imageUrl: String,
    @SerializedName("idMeal") val id: String,
    @SerializedName("strInstructions") val recipe: String
)