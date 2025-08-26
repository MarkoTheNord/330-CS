package com.example.recipemanager.di;

import com.example.recipemanager.data.remote.ApiService;
import com.example.recipemanager.data.repository.RecipeRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class RepositoryModule_ProvideRecipeRepositoryFactory implements Factory<RecipeRepository> {
  private final Provider<ApiService> apiProvider;

  public RepositoryModule_ProvideRecipeRepositoryFactory(Provider<ApiService> apiProvider) {
    this.apiProvider = apiProvider;
  }

  @Override
  public RecipeRepository get() {
    return provideRecipeRepository(apiProvider.get());
  }

  public static RepositoryModule_ProvideRecipeRepositoryFactory create(
      Provider<ApiService> apiProvider) {
    return new RepositoryModule_ProvideRecipeRepositoryFactory(apiProvider);
  }

  public static RecipeRepository provideRecipeRepository(ApiService api) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.provideRecipeRepository(api));
  }
}
