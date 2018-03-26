package br.com.hussan.githubapi.data

import br.com.hussan.githubapi.injection.ApiModule
import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

@Module
class DebugApiModule: ApiModule() {

    override fun getOkHttpBuilder(): OkHttpClient.Builder {
        val interceptor = HttpLoggingInterceptor()

        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return super.getOkHttpBuilder()
                .addInterceptor(interceptor)
                .addNetworkInterceptor(StethoInterceptor())
    }
}
