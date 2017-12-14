package br.com.hussan.githubapi.data

import br.com.hussan.githubapi.data.api.ApiInterface
import br.com.hussan.githubapi.data.model.Repository
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable

interface RepositoryDataSource {
    fun getAllRepositories(): Observable<List<Repository>>
}

class RepositoryModel: RepositoryDataSource {

    val apiService: ApiInterface by lazy {
       Retrofit.Builder().baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(OkHttpClient.Builder().build()).build().create(ApiInterface::class.java)
    }

    override fun getAllRepositories(): Observable<List<Repository>>
    {
        return apiService.repositories("helabs")

    }
}
