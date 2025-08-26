package com.example.recipemanager.di;

import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

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
public final class NetworkModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final Provider<Gson> gsonProvider;

  private final Provider<OkHttpClient> clientProvider;

  public NetworkModule_ProvideRetrofitFactory(Provider<Gson> gsonProvider,
      Provider<OkHttpClient> clientProvider) {
    this.gsonProvider = gsonProvider;
    this.clientProvider = clientProvider;
  }

  @Override
  public Retrofit get() {
    return provideRetrofit(gsonProvider.get(), clientProvider.get());
  }

  public static NetworkModule_ProvideRetrofitFactory create(Provider<Gson> gsonProvider,
      Provider<OkHttpClient> clientProvider) {
    return new NetworkModule_ProvideRetrofitFactory(gsonProvider, clientProvider);
  }

  public static Retrofit provideRetrofit(Gson gson, OkHttpClient client) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideRetrofit(gson, client));
  }
}
