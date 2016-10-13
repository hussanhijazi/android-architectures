package br.com.hussan.githubapi

import android.app.Application
import br.com.hussan.githubapi.ui.repositories.RepositoriesModule

/**
 * Created by hussan on 10/10/16.
 */

class GithubApp : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .repositoriesModule(RepositoriesModule())
                .build()
    }
}
