@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)

package com.example.recipemanager.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.recipemanager.data.remote.dto.RecipeDto
import com.example.recipemanager.viewmodel.AuthorViewModel
import com.example.recipemanager.viewmodel.RecipeViewModel

@Composable
fun AddEditRecipeScreen(
    nav: NavController,
    id: Int?,
    vm: RecipeViewModel = hiltViewModel(),
    authorVm: AuthorViewModel = hiltViewModel()
) {
    val authors by authorVm.authors.collectAsState()

    var title by rememberSaveable { mutableStateOf("") }
    var instructions by rememberSaveable { mutableStateOf("") }
    var imageUrl by rememberSaveable { mutableStateOf("") }
    var authorId by rememberSaveable { mutableStateOf<Int?>(null) }

    var dropdownExpanded by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        authorVm.loadAuthors()
    }

    // ⬇️ Bitno: inicijalizacija/validacija authorId samo kad se lista autora promeni
    LaunchedEffect(authors) {
        if (authors.isNotEmpty()) {
            if (authorId == null || authors.none { it.id == authorId }) {
                authorId = authors.firstOrNull { it.id != null }?.id
            }
        } else {
            authorId = null
        }
    }

    val canSave = title.isNotBlank() && instructions.isNotBlank() && authorId != null

    Scaffold(
        topBar = { TopAppBar(title = { Text(if (id == null) "Add Recipe" else "Edit Recipe") }) }
    ) { pad ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(pad)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = instructions,
                onValueChange = { instructions = it },
                label = { Text("Instructions") },
                modifier = Modifier.fillMaxWidth(),
                minLines = 3
            )
            OutlinedTextField(
                value = imageUrl,
                onValueChange = { imageUrl = it },
                label = { Text("Image URL") },
                modifier = Modifier.fillMaxWidth()
            )

            if (authors.isEmpty()) {
                Text("No authors yet. Add one on Authors screen.")
            } else {
                // Dropdown za izbor autora (stabilno, bez state-a u telu kompozicije)
                ExposedDropdownMenuBox(
                    expanded = dropdownExpanded,
                    onExpandedChange = { dropdownExpanded = !dropdownExpanded }
                ) {
                    OutlinedTextField(
                        readOnly = true,
                        value = authors.firstOrNull { it.id == authorId }?.name ?: "Select author",
                        onValueChange = {},
                        label = { Text("Author") },
                        modifier = Modifier
                            .menuAnchor()
                            .fillMaxWidth()
                    )
                    ExposedDropdownMenu(
                        expanded = dropdownExpanded,
                        onDismissRequest = { dropdownExpanded = false }
                    ) {
                        authors.forEach { a ->
                            DropdownMenuItem(
                                text = { Text(a.name) },
                                onClick = {
                                    authorId = a.id
                                    dropdownExpanded = false
                                }
                            )
                        }
                    }
                }
            }

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Button(
                    onClick = {
                        val aid = authorId ?: return@Button
                        val dto = RecipeDto(
                            id = id,
                            title = title,
                            instructions = instructions,
                            imageUrl = imageUrl,
                            authorId = aid
                        )
                        if (id == null) vm.repoCreate(dto) else vm.repoUpdate(dto)
                        nav.popBackStack()
                    },
                    enabled = canSave
                ) { Text(if (id == null) "Create" else "Save") }

                OutlinedButton(onClick = { nav.popBackStack() }) { Text("Cancel") }
            }
        }
    }
}
