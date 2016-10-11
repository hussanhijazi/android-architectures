package br.com.hussan.githubapi

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by hussan on 10/10/16.
 */
@Module
class AppModule(internal var githubApp: GithubApp) {

    @Singleton
    @Provides
    fun providesGithutApp(): GithubApp {
        return githubApp
    }
}
