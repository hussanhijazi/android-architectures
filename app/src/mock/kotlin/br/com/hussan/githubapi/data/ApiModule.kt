package br.com.hussan.githubapi.data

import br.com.hussan.githubapi.data.remote.FakeAppApi
import br.com.hussan.githubapi.data.remote.AppApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
open class ApiModule {

    @Provides
    @Singleton
    fun providesAppApi(): AppApi = FakeAppApi()


    open fun getOkHttpBuilder(): OkHttpClient.Builder {
        throw UnsupportedOperationException()
      }
}
