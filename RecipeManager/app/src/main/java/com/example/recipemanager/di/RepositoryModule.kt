package com.example.recipemanager.di

import com.example.recipemanager.data.remote.ApiService
import com.example.recipemanager.data.repository.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides @Singleton
    fun provideRecipeRepository(api: ApiService): RecipeRepository =
        RecipeRepository(api)
}
