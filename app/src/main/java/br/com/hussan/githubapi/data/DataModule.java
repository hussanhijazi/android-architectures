package br.com.hussan.githubapi.data;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import br.com.hussan.githubapi.GithubApp;
import br.com.hussan.githubapi.data.api.ApiModule;
import dagger.Module;
import dagger.Provides;

/**
 * Created by hussan on 10/10/16.
 */
@Module(includes = {ApiModule.class})
public class DataModule {

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences(GithubApp app) {
        return app.getSharedPreferences("githubApp", Context.MODE_PRIVATE);
    }
}
