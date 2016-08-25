package br.com.hussan.githubapi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AndroidModule {

    private final GithubApp app;

    public AndroidModule(GithubApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public GithubApp providesGithubApp() {
        return app;
    }
}
