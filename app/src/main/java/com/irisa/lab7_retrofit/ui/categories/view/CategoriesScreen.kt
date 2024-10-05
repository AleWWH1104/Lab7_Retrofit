package com.irisa.lab7_retrofit.ui.categories.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.irisa.lab7_retrofit.networking.response.MealCategory
import coil.compose.rememberAsyncImagePainter
import com.irisa.lab7_retrofit.navigation.AppBar
import com.irisa.lab7_retrofit.ui.categories.viewmodel.CategoryViewModel
import com.irisa.lab7_retrofit.ui.theme.Lab7_retrofitTheme

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
                Category_Card(meal)
            }
        }
    }
}

@Composable
fun Category_Card(meal: MealCategory){
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
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


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab7_retrofitTheme {
        val navController = rememberNavController()
        Categories_Screen(navController)
    }
}