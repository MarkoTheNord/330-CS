@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)

package com.example.recipemanager.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.recipemanager.viewmodel.AuthorViewModel
import com.example.recipemanager.viewmodel.RecipeViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart

@Composable
fun RecipeDetailScreen(
    nav: NavController,
    id: Int,
    vm: RecipeViewModel = hiltViewModel(),
    authorVm: AuthorViewModel = hiltViewModel()
) {
    val authors by authorVm.authors.collectAsState()

    var loading by remember { mutableStateOf(true) }
    var error by remember { mutableStateOf<String?>(null) }
    var title by remember { mutableStateOf("") }
    var instructions by remember { mutableStateOf("") }
    var imageUrl by remember { mutableStateOf("") }
    var authorId by remember { mutableStateOf(0) }
    var authorNameFromExpand by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) { authorVm.loadAuthors() }

    LaunchedEffect(id) {
        vm.repo.getRecipe(id)
            .onStart { loading = true; error = null }
            .catch { e -> loading = false; error = e.message }
            .collect { r ->
                loading = false
                title = r.title
                instructions = r.instructions
                imageUrl = r.imageUrl
                authorId = r.authorId
                authorNameFromExpand = r.author?.name.orEmpty() // može biti ""
            }
    }

    // Fallback: ako expand nije vratio autora, pokušaj iz liste autora
    val authorName = remember(authors, authorId, authorNameFromExpand) {
        if (authorNameFromExpand.isNotBlank()) authorNameFromExpand
        else authors.firstOrNull { it.id == authorId }?.name ?: "Unknown author"
    }

    Scaffold(topBar = { TopAppBar(title = { Text("Recipe Details") }) }) { pad ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(pad)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            if (loading) CircularProgressIndicator()
            error?.let { Text("Error: $it") }

            if (!loading && error == null) {
                AsyncImage(model = imageUrl, contentDescription = null, modifier = Modifier.fillMaxWidth())
                Text(title, style = MaterialTheme.typography.headlineSmall)
                Text("Author: $authorName", style = MaterialTheme.typography.bodyMedium)

                Button(onClick = { expanded = !expanded }) {
                    Text(if (expanded) "Hide instructions" else "Show instructions")
                }
                AnimatedVisibility(visible = expanded) {
                    Text(instructions, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(top = 8.dp))
                }
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Button(onClick = { nav.navigate("addEdit/$id") }) { Text("Edit") }
                    OutlinedButton(onClick = { nav.popBackStack() }) { Text("Back") }
                }
            }
        }
    }
}
