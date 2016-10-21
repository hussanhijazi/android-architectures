package br.com.hussan.githubapi.ui.repositories.ui

import br.com.hussan.githubapi.ui.repositories.RepositoriesActivity
import dagger.Subcomponent

/**
 * Created by hussan on 10/18/16.
 */
@PerActivity
@Subcomponent(modules = arrayOf(PresenterModule::class))
interface UiComponent {
    fun inject(repositoriesActivity: RepositoriesActivity)
}