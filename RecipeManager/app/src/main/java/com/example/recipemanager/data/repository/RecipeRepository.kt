package com.example.recipemanager.data.repository

import com.example.recipemanager.data.remote.ApiService
import com.example.recipemanager.data.remote.dto.AuthorDto
import com.example.recipemanager.data.remote.dto.RecipeDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RecipeRepository(private val api: ApiService) {

    fun getRecipes(): Flow<List<RecipeDto>> = flow { emit(api.getRecipes()) }
    fun getRecipe(id: Int): Flow<RecipeDto> = flow { emit(api.getRecipe(id)) }

    fun createRecipe(recipe: RecipeDto): Flow<RecipeDto> = flow { emit(api.createRecipe(recipe)) }
    fun updateRecipe(id: Int, recipe: RecipeDto): Flow<RecipeDto> = flow { emit(api.updateRecipe(id, recipe)) }
    fun deleteRecipe(id: Int): Flow<Unit> = flow { api.deleteRecipe(id); emit(Unit) }

    fun getAuthors(): Flow<List<AuthorDto>> = flow { emit(api.getAuthors()) }
    fun createAuthor(author: AuthorDto): Flow<AuthorDto> = flow { emit(api.createAuthor(author)) }

    fun createAuthorWithNumericId(name: String) = flow {
        val current = api.getAuthors()
        val nextId = (current.mapNotNull { it.id }.maxOrNull() ?: 0) + 1
        emit(api.createAuthor(AuthorDto(id = nextId, name = name)))
    }

    suspend fun deleteAuthor(id: Int) {
        api.deleteAuthor(id)
    }
}

