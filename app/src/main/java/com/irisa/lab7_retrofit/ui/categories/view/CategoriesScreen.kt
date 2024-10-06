package com.irisa.lab7_retrofit.ui.categories.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.irisa.lab7_retrofit.networking.response.MealCategory
import coil.compose.rememberAsyncImagePainter
import com.irisa.lab7_retrofit.navigation.AppBar
import com.irisa.lab7_retrofit.navigation.NavigationState
import com.irisa.lab7_retrofit.ui.categories.viewmodel.CategoryViewModel

@Composable
fun Categories_Screen(navController: NavController) {
    val viewModel: CategoryViewModel = viewModel()
    val meals = viewModel.mealsState.value

    // Usa Scaffold para que el AppBar se mantenga fijo en la parte superior
    Scaffold(
        topBar = {
            AppBar(title = "Categorias", navController)
        }
    ) { paddingValues ->
        // Añade padding para evitar que el contenido se superponga con la AppBar
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.padding(paddingValues) // Aplica el padding proporcionado por Scaffold
        ) {
            items(meals) { meal ->
                Category_Card(meal, navController)
            }
        }
    }
}

@Composable
fun Category_Card(meal: MealCategory, navController: NavController){
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .clickable {
                navController.navigate(NavigationState.MealsFilters.createRoute(meal.category))
            },
        colors = CardDefaults.cardColors(containerColor = Color(0xFF8797AF))

    ){
        Row(){
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

            ){
                Text(
                    text = meal.category ?: "",
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }
    }
}
