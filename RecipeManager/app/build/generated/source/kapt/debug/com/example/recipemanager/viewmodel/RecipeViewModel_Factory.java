package com.example.recipemanager.viewmodel;

import com.example.recipemanager.data.repository.RecipeRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class RecipeViewModel_Factory implements Factory<RecipeViewModel> {
  private final Provider<RecipeRepository> repoProvider;

  public RecipeViewModel_Factory(Provider<RecipeRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public RecipeViewModel get() {
    return newInstance(repoProvider.get());
  }

  public static RecipeViewModel_Factory create(Provider<RecipeRepository> repoProvider) {
    return new RecipeViewModel_Factory(repoProvider);
  }

  public static RecipeViewModel newInstance(RecipeRepository repo) {
    return new RecipeViewModel(repo);
  }
}
