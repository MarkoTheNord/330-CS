package com.example.recipemanager.viewmodel;

import androidx.lifecycle.ViewModel;
import com.example.recipemanager.data.remote.dto.RecipeDto;
import com.example.recipemanager.data.repository.RecipeRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/example/recipemanager/viewmodel/RecipeViewModel;", "Landroidx/lifecycle/ViewModel;", "repo", "Lcom/example/recipemanager/data/repository/RecipeRepository;", "(Lcom/example/recipemanager/data/repository/RecipeRepository;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/recipemanager/viewmodel/RecipeUiState;", "getRepo", "()Lcom/example/recipemanager/data/repository/RecipeRepository;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "deleteRecipe", "", "id", "", "refresh", "repoCreate", "dto", "Lcom/example/recipemanager/data/remote/dto/RecipeDto;", "repoUpdate", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class RecipeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.recipemanager.data.repository.RecipeRepository repo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.recipemanager.viewmodel.RecipeUiState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.recipemanager.viewmodel.RecipeUiState> state = null;
    
    @javax.inject.Inject()
    public RecipeViewModel(@org.jetbrains.annotations.NotNull()
    com.example.recipemanager.data.repository.RecipeRepository repo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.recipemanager.data.repository.RecipeRepository getRepo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.recipemanager.viewmodel.RecipeUiState> getState() {
        return null;
    }
    
    public final void refresh() {
    }
    
    public final void deleteRecipe(int id) {
    }
    
    public final void repoCreate(@org.jetbrains.annotations.NotNull()
    com.example.recipemanager.data.remote.dto.RecipeDto dto) {
    }
    
    public final void repoUpdate(@org.jetbrains.annotations.NotNull()
    com.example.recipemanager.data.remote.dto.RecipeDto dto) {
    }
}