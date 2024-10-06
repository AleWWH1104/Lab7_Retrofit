package com.irisa.lab7_retrofit.ui.meals.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.irisa.lab7_retrofit.navigation.AppBar
import com.irisa.lab7_retrofit.navigation.NavigationState
import com.irisa.lab7_retrofit.networking.response.MealFilter
import com.irisa.lab7_retrofit.ui.meals.viewmodel.MealViewModel

@Composable
fun Meal_Category_Card(meal: MealFilter, navController: NavController) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .clickable {
                navController.navigate(NavigationState.MealsLook.createRoute(meal.id))
            },
        colors = CardDefaults.cardColors(containerColor = Color(0xFF8797AF))
    ) {
        Row {
            Image(
                painter = rememberAsyncImagePainter(meal.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(88.dp)
                    .padding(4.dp)
            )
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
            ) {
                Text(
                    text = meal.name ?: "",
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }
    }
}

@Composable
fun Meals_Category_Screen(category: String, navController: NavController) {
    val viewModel: MealViewModel = viewModel()
    val mealFilter by viewModel.meals.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchByCategory(category)
    }

    Scaffold(
        topBar = {
            AppBar(title = category, navController = navController)
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.padding(paddingValues)
        ) {
            // Solo iteramos si la lista tiene elementos
            if (mealFilter.isNotEmpty()) {
                items(mealFilter) { meal ->
                    Meal_Category_Card(meal, navController)
                }
            } else {
                item {
                    Text(
                        text = "Cargando comidas disponibles...",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}


