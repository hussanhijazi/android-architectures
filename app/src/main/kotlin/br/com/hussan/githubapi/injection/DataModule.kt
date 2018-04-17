package br.com.hussan.githubapi.app.injection.module

import br.com.hussan.githubapi.AppExecutors
import br.com.hussan.githubapi.data.UserDataSource
import br.com.hussan.githubapi.data.UserRepository
import br.com.hussan.githubapi.data.local.PreferencesDataSource
import br.com.hussan.githubapi.data.local.db.UserDao
import br.com.hussan.githubapi.data.remote.AppApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun providesUserDataSource(appApi: AppApi, userDao: UserDao,
                               sharedPreferences: PreferencesDataSource,
                               appExecutors: AppExecutors): UserDataSource =
            UserRepository(appApi, userDao, sharedPreferences, appExecutors)

}
