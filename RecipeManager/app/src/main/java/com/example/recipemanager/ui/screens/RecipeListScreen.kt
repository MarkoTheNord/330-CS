package com.example.recipemanager.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.recipemanager.viewmodel.RecipeViewModel

@Composable
fun RecipeListScreen(nav: NavController, vm: RecipeViewModel = hiltViewModel()) {
    val state by vm.state.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Recipes") },
                actions = {
                    TextButton(onClick = { nav.navigate("authors") }) { Text("Authors") }
                })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { nav.navigate("addEdit") }) { Text("+") }
        }
    ) { pad ->
        Box(Modifier.fillMaxSize().padding(pad)) {
            when {
                state.isLoading -> CircularProgressIndicator(Modifier.align(Alignment.Center))
                state.error != null -> Text("Error: ${state.error}")
                else -> {
                    LazyColumn(Modifier.fillMaxSize().padding(12.dp)) {
                        items(state.recipes) { r ->
                            ElevatedCard(
                                Modifier.fillMaxWidth().padding(vertical = 6.dp)
                                    .clickable { nav.navigate("recipe/${r.id}") }
                            ) {
                                Row(Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
                                    AsyncImage(model = r.imageUrl, contentDescription = null,
                                        modifier = Modifier.size(72.dp))
                                    Spacer(Modifier.width(12.dp))
                                    Column(Modifier.weight(1f)) {
                                        Text(r.title, style = MaterialTheme.typography.titleMedium)
                                        Text(r.author?.name ?: "Unknown author", style = MaterialTheme.typography.bodySmall)
                                    }
                                    TextButton(onClick = { r.id?.let { vm.deleteRecipe(it) } }) { Text("Delete") }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
