package br.com.hussan.githubapi;

import javax.inject.Singleton;

import br.com.hussan.githubapi.data.DataModule;
import br.com.hussan.githubapi.ui.repositories.MainActivity;
import dagger.Component;

/**
 * Created by hussan on 10/10/16.
 */
@Singleton
@Component(modules = {AppModule.class, DataModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
}
