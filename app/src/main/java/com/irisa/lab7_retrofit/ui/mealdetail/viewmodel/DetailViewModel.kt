package com.irisa.lab7_retrofit.ui.mealdetail.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irisa.lab7_retrofit.networking.response.MealLook
import com.irisa.lab7_retrofit.ui.mealdetail.repository.DetailRepository
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: DetailRepository = DetailRepository()): ViewModel() {
    private val _mealDetail = MutableLiveData<MealLook?>()
    val mealDetail: LiveData<MealLook?> = _mealDetail

    fun fetchMealDetail(mealId: String) {
        viewModelScope.launch {
            try {
                val meal = repository.getMealsLook(mealId)
                _mealDetail.value = meal
            } catch (e: Exception) {
                Log.e("MealDetailViewModel", "Error fetching meal detail: ${e.message}")
            }
        }
    }
}