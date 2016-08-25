package br.com.hussan.githubapi.data.api;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    @ApiUrl
    @Provides
    @Singleton
    public String provideApiUrl() {
        return "https://api.github.com";
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttp() {
        return new OkHttpClient.Builder().build();
    }

    @Provides
    @Singleton
    public ApiInterface provideApi(@ApiUrl String url, OkHttpClient okHttp) {
        return new Retrofit.Builder()
                .client(okHttp)
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(ApiInterface.class);
    }
}
