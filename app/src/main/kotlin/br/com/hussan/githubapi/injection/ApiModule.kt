package br.com.hussan.githubapi.injection

import android.content.Context
import br.com.hussan.githubapi.BuildConfig
import br.com.hussan.githubapi.data.LiveDataCallAdapterFactory
import br.com.hussan.githubapi.data.remote.AppApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
open class ApiModule {

    open fun getOkHttpBuilder(): OkHttpClient.Builder = OkHttpClient.Builder()

    @Provides
    @Singleton
    fun providesOkHttpClient(@Named("ApplicationContext") context: Context): OkHttpClient {
//        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val interceptor = HttpLoggingInterceptor()

        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return getOkHttpBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(interceptor)

            .addInterceptor { chain ->
                    val original = chain.request()

//                    if (!connectivityManager.isConnected) {
//                        throw NoNetworkException
//                    }

                    val requestBuilder = original.newBuilder()

                    // Store token if needed in sharedPreferences

                    val response = chain.proceed(requestBuilder.method(original.method(), original.body()).build())

                    response
                }
                .build()
    }

    @Provides
    @Singleton
    fun providesAppApi(okHttpClient: OkHttpClient): AppApi {
        val retrofit = Retrofit.Builder()
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.API_URL)
                .client(okHttpClient)
                .build()

        return retrofit.create(AppApi::class.java)
    }

    @Provides
    @Singleton
    fun providesGson(): Gson = GsonBuilder().create()

}