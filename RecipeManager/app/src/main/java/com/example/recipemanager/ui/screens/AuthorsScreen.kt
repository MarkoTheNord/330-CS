package com.example.recipemanager.ui.screens

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
import com.example.recipemanager.viewmodel.AuthorViewModel

@Composable
fun AuthorsScreen(nav: NavController, vm: AuthorViewModel = hiltViewModel()) {
    val authors by vm.authors.collectAsState()
    var name by remember { mutableStateOf("") }
    var confirmDeleteId by remember { mutableStateOf<Int?>(null) }

    // Ako ViewModel ne učitava sam autore u init, odkomentariši:
    // LaunchedEffect(Unit) { vm.loadAuthors() }

    Scaffold(topBar = { TopAppBar(title = { Text("Authors") }) }) { pad ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(pad)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Author name") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = {
                    if (name.isNotBlank()) {
                        vm.addAuthor(name)
                        name = ""
                    }
                }
            ) { Text("Add Author") }

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(
                    items = authors,
                    key = { it.id ?: it.name.hashCode() }
                ) { a ->
                    ElevatedCard(Modifier.fillMaxWidth()) {
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                a.name,
                                style = MaterialTheme.typography.titleMedium,
                                modifier = Modifier.weight(1f)
                            )
                            OutlinedButton(
                                onClick = { a.id?.let { confirmDeleteId = it } },
                                enabled = a.id != null
                            ) { Text("Delete") }
                        }
                    }
                }
            }
        }
    }

    // Confirm dialog
    if (confirmDeleteId != null) {
        AlertDialog(
            onDismissRequest = { confirmDeleteId = null },
            title = { Text("Delete author") },
            text = { Text("Are you sure you want to delete this author?") },
            confirmButton = {
                TextButton(onClick = {
                    val id = confirmDeleteId!!
                    vm.deleteAuthor(id)
                    confirmDeleteId = null
                }) { Text("Delete") }
            },
            dismissButton = {
                TextButton(onClick = { confirmDeleteId = null }) { Text("Cancel") }
            }
        )
    }
}
