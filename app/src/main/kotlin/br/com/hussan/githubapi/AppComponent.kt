package br.com.hussan.githubapi

import br.com.hussan.githubapi.data.DataModule
import br.com.hussan.githubapi.ui.repositories.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by hussan on 10/10/16.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, DataModule::class))
interface AppComponent {
    fun inject(activity: MainActivity)
}
