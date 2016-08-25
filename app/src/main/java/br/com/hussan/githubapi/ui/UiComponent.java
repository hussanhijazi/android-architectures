package br.com.hussan.githubapi.ui;

import br.com.hussan.githubapi.ui.repositories.MainActivity;
import dagger.Subcomponent;

@PerActivity
@Subcomponent
public interface UiComponent {
    void inject(MainActivity mainActivity);
}
