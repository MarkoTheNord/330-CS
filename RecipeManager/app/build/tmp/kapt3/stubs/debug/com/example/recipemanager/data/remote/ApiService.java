package com.example.recipemanager.data.remote;

import com.example.recipemanager.data.remote.dto.AuthorDto;
import com.example.recipemanager.data.remote.dto.RecipeDto;
import retrofit2.http.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\"\u0010\u0015\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\b\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/example/recipemanager/data/remote/ApiService;", "", "createAuthor", "Lcom/example/recipemanager/data/remote/dto/AuthorDto;", "author", "(Lcom/example/recipemanager/data/remote/dto/AuthorDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createRecipe", "Lcom/example/recipemanager/data/remote/dto/RecipeDto;", "recipe", "(Lcom/example/recipemanager/data/remote/dto/RecipeDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAuthor", "", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRecipe", "getAuthors", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecipe", "getRecipes", "updateRecipe", "(ILcom/example/recipemanager/data/remote/dto/RecipeDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ApiService {
    
    @retrofit2.http.GET(value = "recipes?_expand=author")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRecipes(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.recipemanager.data.remote.dto.RecipeDto>> $completion);
    
    @retrofit2.http.GET(value = "recipes/{id}?_expand=author")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRecipe(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.recipemanager.data.remote.dto.RecipeDto> $completion);
    
    @retrofit2.http.POST(value = "recipes")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createRecipe(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.recipemanager.data.remote.dto.RecipeDto recipe, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.recipemanager.data.remote.dto.RecipeDto> $completion);
    
    @retrofit2.http.PUT(value = "recipes/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateRecipe(@retrofit2.http.Path(value = "id")
    int id, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.recipemanager.data.remote.dto.RecipeDto recipe, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.recipemanager.data.remote.dto.RecipeDto> $completion);
    
    @retrofit2.http.DELETE(value = "recipes/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteRecipe(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @retrofit2.http.GET(value = "authors")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAuthors(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.recipemanager.data.remote.dto.AuthorDto>> $completion);
    
    @retrofit2.http.POST(value = "authors")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createAuthor(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.recipemanager.data.remote.dto.AuthorDto author, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.recipemanager.data.remote.dto.AuthorDto> $completion);
    
    @retrofit2.http.DELETE(value = "authors/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAuthor(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}