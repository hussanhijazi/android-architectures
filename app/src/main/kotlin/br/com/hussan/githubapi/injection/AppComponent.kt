

package br.com.hussan.githubapi.injection

import android.app.Application
import br.com.hussan.githubapi.AppApplication
import br.com.hussan.githubapi.app.injection.module.DataModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        AppModule::class,
        ApiModule::class,
        DBModule::class,
        DataModule::class,
        ActivityModule::class))
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(githubApp: AppApplication)
}
