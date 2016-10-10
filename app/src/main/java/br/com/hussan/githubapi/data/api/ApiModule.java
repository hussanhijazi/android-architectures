package br.com.hussan.githubapi.data.api;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by hussan on 10/10/16.
 */
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
    public Converter.Factory provideConverterFactory()
    {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttp()
    {
        return new OkHttpClient.Builder().build();
    }

    @Provides
    @Singleton
    public ApiInterface provideApi(@ApiUrl String url, OkHttpClient okHttpClient, Converter.Factory converterFactory)
    {
        return new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(converterFactory)
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .client(okHttpClient)
                        .build()
                        .create(ApiInterface.class);
    }

}
