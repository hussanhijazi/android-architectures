package br.com.hussan.githubapi.injection

import android.app.Application
import android.content.Context
import br.com.hussan.githubapi.AppApplication
import br.com.hussan.githubapi.AppExecutors
import br.com.hussan.githubapi.data.local.PreferencesDataSource
import br.com.hussan.githubapi.data.local.PreferencesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = arrayOf(ViewModelModule::class))
class AppModule {

    @Provides
    @Singleton
    fun providesPreferencesRepository(application: Application): PreferencesDataSource
            = PreferencesRepository(application)

    @Provides
    @Singleton
    @Named("ApplicationContext")
    fun providesApplicationContext(application: Application): Context = application

    @Provides
    @Singleton
    fun providesApplication(application: AppApplication): AppApplication = application

        @Provides
    @Singleton
    fun providesAppExecutor() = AppExecutors()
}