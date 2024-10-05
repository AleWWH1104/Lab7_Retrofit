package com.irisa.lab7_retrofit.ui.categories.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irisa.lab7_retrofit.networking.response.MealCategory
import com.irisa.lab7_retrofit.ui.categories.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryViewModel(private val repository: CategoryRepository = CategoryRepository()):ViewModel() {

    val mealsState: MutableState<List<MealCategory>> =  mutableStateOf(emptyList<MealCategory>())
    init{
        viewModelScope.launch(Dispatchers.IO) {
            val meals = getMealsCategories()
            mealsState.value = meals
        }
    }

    private suspend fun getMealsCategories(): List<MealCategory> {
        return repository.getMealsCategories()
    }

}