package com.irisa.lab7_retrofit.ui.meals.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irisa.lab7_retrofit.networking.response.MealFilter
import com.irisa.lab7_retrofit.ui.meals.repository.MealRepository
import kotlinx.coroutines.launch

class MealViewModel(private val repository: MealRepository = MealRepository()): ViewModel() {
    private val mealsbycat = MutableLiveData<List<MealFilter>>()
    val meals: LiveData<List<MealFilter>> = mealsbycat

    fun fetchByCategory(category: String) {
        viewModelScope.launch {
            try {
                val meals = repository.getMealsFilter(category)
                mealsbycat.value = meals
            } catch (e: Exception) {
                Log.e("MealsViewModel", e.message.toString());
            }
        }
    }
}

