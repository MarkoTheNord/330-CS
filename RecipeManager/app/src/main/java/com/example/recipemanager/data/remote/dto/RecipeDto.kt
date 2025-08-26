package com.example.recipemanager.data.remote.dto

data class RecipeDto(
    val id: Int? = null,
    val title: String,
    val instructions: String,
    val imageUrl: String,
    val authorId: Int,
    val author: AuthorDto? = null
)