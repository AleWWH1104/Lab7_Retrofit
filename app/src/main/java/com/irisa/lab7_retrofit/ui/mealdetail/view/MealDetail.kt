package com.irisa.lab7_retrofit.ui.mealdetail.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.irisa.lab7_retrofit.ui.mealdetail.viewmodel.DetailViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.*
import com.irisa.lab7_retrofit.navigation.AppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import coil.compose.rememberAsyncImagePainter

@Composable
fun Meal_Detail_Screen(id: String, navController: NavController){
    val viewModel: DetailViewModel = viewModel()
    val mealDetail by viewModel.mealDetail.observeAsState(null)

    LaunchedEffect(Unit) {
        viewModel.fetchMealDetail(id)
    }

    Scaffold(
        topBar = {
            AppBar(title = "Recetas", navController = navController)
        }
    ){paddingValues ->
        mealDetail?.let { meal ->
            Column(modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
            ){
                Image(
                    painter = rememberAsyncImagePainter(meal.imageUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(text = meal.name, style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "Categoría: ${meal.category}", style = MaterialTheme.typography.titleSmall)
                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "Receta: ${meal.recipe}")
            }
        } ?: run {
            Text(text = "Cargando detalles de la comida...")
        }
    }
}