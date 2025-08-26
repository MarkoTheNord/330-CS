package com.example.recipemanager.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipemanager.data.remote.dto.RecipeDto
import com.example.recipemanager.data.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class RecipeUiState(
    val isLoading: Boolean = false,
    val recipes: List<RecipeDto> = emptyList(),
    val error: String? = null
)

@HiltViewModel
class RecipeViewModel @Inject constructor(
    val repo: RecipeRepository
) : ViewModel() {

    private val _state = MutableStateFlow(RecipeUiState(isLoading = true))
    val state: StateFlow<RecipeUiState> = _state.asStateFlow()

    init { refresh() }

    fun refresh() {
        viewModelScope.launch {
            repo.getRecipes()
                .onStart { _state.update { it.copy(isLoading = true, error = null) } }
                .catch { e -> _state.update { it.copy(isLoading = false, error = e.message) } }
                .collect { list -> _state.update { it.copy(isLoading = false, recipes = list) } }
        }
    }

    fun deleteRecipe(id: Int) {
        viewModelScope.launch { repo.deleteRecipe(id).collect { refresh() } }
    }

    fun repoCreate(dto: RecipeDto) {
        viewModelScope.launch { repo.createRecipe(dto).collect { refresh() } }
    }

    fun repoUpdate(dto: RecipeDto) {
        val rid = dto.id ?: return
        viewModelScope.launch { repo.updateRecipe(rid, dto).collect { refresh() } }
    }
}
