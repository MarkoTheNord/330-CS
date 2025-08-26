package com.example.recipemanager.data.remote

import com.example.recipemanager.data.remote.dto.AuthorDto
import com.example.recipemanager.data.remote.dto.RecipeDto
import retrofit2.http.*

interface ApiService {
    @GET("recipes?_expand=author")
    suspend fun getRecipes(): List<RecipeDto>

    @GET("recipes/{id}?_expand=author")
    suspend fun getRecipe(@Path("id") id: Int): RecipeDto

    @POST("recipes")
    suspend fun createRecipe(@Body recipe: RecipeDto): RecipeDto

    @PUT("recipes/{id}")
    suspend fun updateRecipe(@Path("id") id: Int, @Body recipe: RecipeDto): RecipeDto

    @DELETE("recipes/{id}")
    suspend fun deleteRecipe(@Path("id") id: Int)

    @GET("authors")
    suspend fun getAuthors(): List<AuthorDto>

    @POST("authors")
    suspend fun createAuthor(@Body author: AuthorDto): AuthorDto

    @DELETE("authors/{id}")
    suspend fun deleteAuthor(@Path("id") id: Int)
}
