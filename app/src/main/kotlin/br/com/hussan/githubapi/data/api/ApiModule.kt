package br.com.hussan.githubapi.data.api

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 * Created by hussan on 10/10/16.
 */
@Module
class ApiModule {


    @ApiUrl
    @Provides
    @Singleton
    fun provideApiUrl(): String {
        return "https://api.github.com"
    }

    @Provides
    @Singleton
    fun provideConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    fun provideApi(@ApiUrl url: String, okHttpClient: OkHttpClient, converterFactory: Converter.Factory): ApiInterface {
        return Retrofit.Builder().baseUrl(url).addConverterFactory(converterFactory).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).client(okHttpClient).build().create(ApiInterface::class.java)
    }

}
