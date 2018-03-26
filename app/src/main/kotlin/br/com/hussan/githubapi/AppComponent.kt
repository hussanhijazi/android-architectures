package br.com.hussan.githubapi

import br.com.hussan.githubapi.data.api.ApiModule
import br.com.hussan.githubapi.injection.ui.PresenterModule
import br.com.hussan.githubapi.injection.ui.UiComponent
import dagger.Component
import javax.inject.Singleton

/**
 * Created by hussan on 10/10/16.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, ApiModule::class))
interface AppComponent {
    fun plus(presenterModule: PresenterModule) : UiComponent
}
