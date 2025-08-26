package com.example.recipemanager.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipemanager.data.remote.dto.AuthorDto
import com.example.recipemanager.data.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorViewModel @Inject constructor(
    private val repo: RecipeRepository
) : ViewModel() {

    private val _authors = MutableStateFlow<List<AuthorDto>>(emptyList())
    val authors: StateFlow<List<AuthorDto>> = _authors.asStateFlow()

    init { loadAuthors() }

    fun loadAuthors() {
        viewModelScope.launch { repo.getAuthors().collect { _authors.value = it } }
    }

    fun addAuthor(name: String) {
        viewModelScope.launch {
            repo.createAuthorWithNumericId(name).collect { loadAuthors() }
        }
    }
    fun deleteAuthor(id: Int) {
        viewModelScope.launch {
            try {
                repo.deleteAuthor(id)
                loadAuthors() // refresh listu nakon brisanja
            } catch (e: Exception) {
                // po želji: emituj state.error = e.message
            }
        }
    }
}
