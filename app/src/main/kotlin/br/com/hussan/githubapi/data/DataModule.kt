package br.com.hussan.githubapi.data

import android.content.Context
import android.content.SharedPreferences
import br.com.hussan.githubapi.GithubApp
import br.com.hussan.githubapi.data.api.ApiModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by hussan on 10/10/16.
 */
@Module(includes = arrayOf(ApiModule::class))
class DataModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(app: GithubApp): SharedPreferences {
        return app.getSharedPreferences("githubApp", Context.MODE_PRIVATE)
    }
}
