package com.example.recipemanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { RecipeAppRoot() }
    }
}

@Composable
fun RecipeAppRoot() {
    val nav = rememberNavController()
    MaterialTheme {
        NavHost(navController = nav, startDestination = "recipes") {
            composable("recipes") { com.example.recipemanager.ui.screens.RecipeListScreen(nav) }
            composable("recipe/{id}") { backStack ->
                val id = backStack.arguments?.getString("id")?.toIntOrNull() ?: -1
                com.example.recipemanager.ui.screens.RecipeDetailScreen(nav, id)
            }
            composable("addEdit") { com.example.recipemanager.ui.screens.AddEditRecipeScreen(nav, null) }
            composable("addEdit/{id}") { backStack ->
                val id = backStack.arguments?.getString("id")?.toIntOrNull()
                com.example.recipemanager.ui.screens.AddEditRecipeScreen(nav, id)
            }
            composable("authors") { com.example.recipemanager.ui.screens.AuthorsScreen(nav) }
        }
    }
}
