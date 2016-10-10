package br.com.hussan.githubapi;

import android.app.Application;

/**
 * Created by hussan on 10/10/16.
 */

public class GithubApp extends Application {

    AppComponent component;

    @Override
    public void onCreate()
    {
        super.onCreate();

        component = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
    }

    public AppComponent getComponent()
    {
        return component;
    }
}
