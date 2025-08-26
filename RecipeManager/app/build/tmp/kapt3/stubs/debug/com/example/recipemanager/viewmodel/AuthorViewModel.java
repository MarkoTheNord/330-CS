package com.example.recipemanager.viewmodel;

import androidx.lifecycle.ViewModel;
import com.example.recipemanager.data.remote.dto.AuthorDto;
import com.example.recipemanager.data.repository.RecipeRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u000eR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/recipemanager/viewmodel/AuthorViewModel;", "Landroidx/lifecycle/ViewModel;", "repo", "Lcom/example/recipemanager/data/repository/RecipeRepository;", "(Lcom/example/recipemanager/data/repository/RecipeRepository;)V", "_authors", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/recipemanager/data/remote/dto/AuthorDto;", "authors", "Lkotlinx/coroutines/flow/StateFlow;", "getAuthors", "()Lkotlinx/coroutines/flow/StateFlow;", "addAuthor", "", "name", "", "deleteAuthor", "id", "", "loadAuthors", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AuthorViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.recipemanager.data.repository.RecipeRepository repo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.recipemanager.data.remote.dto.AuthorDto>> _authors = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.recipemanager.data.remote.dto.AuthorDto>> authors = null;
    
    @javax.inject.Inject()
    public AuthorViewModel(@org.jetbrains.annotations.NotNull()
    com.example.recipemanager.data.repository.RecipeRepository repo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.recipemanager.data.remote.dto.AuthorDto>> getAuthors() {
        return null;
    }
    
    public final void loadAuthors() {
    }
    
    public final void addAuthor(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
    
    public final void deleteAuthor(int id) {
    }
}