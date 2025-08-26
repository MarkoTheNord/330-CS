package com.example.recipemanager.data.repository;

import com.example.recipemanager.data.remote.ApiService;
import com.example.recipemanager.data.remote.dto.AuthorDto;
import com.example.recipemanager.data.remote.dto.RecipeDto;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0007J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00062\u0006\u0010\u0011\u001a\u00020\u0012J\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00160\u0006J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u0011\u001a\u00020\u0012J\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00160\u0006J\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/recipemanager/data/repository/RecipeRepository;", "", "api", "Lcom/example/recipemanager/data/remote/ApiService;", "(Lcom/example/recipemanager/data/remote/ApiService;)V", "createAuthor", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/recipemanager/data/remote/dto/AuthorDto;", "author", "createAuthorWithNumericId", "name", "", "createRecipe", "Lcom/example/recipemanager/data/remote/dto/RecipeDto;", "recipe", "deleteAuthor", "", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRecipe", "getAuthors", "", "getRecipe", "getRecipes", "updateRecipe", "app_debug"})
public final class RecipeRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.recipemanager.data.remote.ApiService api = null;
    
    public RecipeRepository(@org.jetbrains.annotations.NotNull()
    com.example.recipemanager.data.remote.ApiService api) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.recipemanager.data.remote.dto.RecipeDto>> getRecipes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.recipemanager.data.remote.dto.RecipeDto> getRecipe(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.recipemanager.data.remote.dto.RecipeDto> createRecipe(@org.jetbrains.annotations.NotNull()
    com.example.recipemanager.data.remote.dto.RecipeDto recipe) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.recipemanager.data.remote.dto.RecipeDto> updateRecipe(int id, @org.jetbrains.annotations.NotNull()
    com.example.recipemanager.data.remote.dto.RecipeDto recipe) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<kotlin.Unit> deleteRecipe(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.recipemanager.data.remote.dto.AuthorDto>> getAuthors() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.recipemanager.data.remote.dto.AuthorDto> createAuthor(@org.jetbrains.annotations.NotNull()
    com.example.recipemanager.data.remote.dto.AuthorDto author) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.recipemanager.data.remote.dto.AuthorDto> createAuthorWithNumericId(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteAuthor(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}