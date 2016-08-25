package br.com.hussan.githubapi;

import android.app.Application;

public class GithubApp extends Application {

    AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder()
                .androidModule(new AndroidModule(this))
                .build();
    }

    public AppComponent getComponent() {
        return component;
    }
}
