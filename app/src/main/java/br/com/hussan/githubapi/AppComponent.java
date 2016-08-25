package br.com.hussan.githubapi;

import javax.inject.Singleton;

import br.com.hussan.githubapi.data.DataModule;
import br.com.hussan.githubapi.ui.UiComponent;
import dagger.Component;

@Singleton
@Component(modules = { AndroidModule.class, DataModule.class})
public interface AppComponent {
    void inject(GithubApp githubApp);

    UiComponent createUiComponent();
}
