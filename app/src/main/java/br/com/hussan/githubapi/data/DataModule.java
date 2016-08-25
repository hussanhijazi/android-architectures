package br.com.hussan.githubapi.data;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import br.com.hussan.githubapi.GithubApp;
import br.com.hussan.githubapi.data.api.ApiModule;
import dagger.Module;
import dagger.Provides;

@Module(includes = {ApiModule.class})
public class DataModule {

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences(GithubApp app) {
        return app.getSharedPreferences("githubApp", Context.MODE_PRIVATE);
    }
}
