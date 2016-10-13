package br.com.hussan.githubapi.ui.repositories

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by hussan on 10/11/16.
 */
@Module
class RepositoriesModule {

    @Singleton
    @Provides
    fun providesPresenter(): RepositoriesPresenter {
        return RepositoriesPresenter()
    }
}
