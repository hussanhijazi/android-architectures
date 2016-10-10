package br.com.hussan.githubapi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hussan on 10/10/16.
 */
@Module
public class AppModule {

    GithubApp githubApp;

    public AppModule(GithubApp githubApp) {
        this.githubApp = githubApp;
    }

    @Singleton
    @Provides
    public GithubApp providesGithutApp()
    {
        return githubApp;
    }
}
