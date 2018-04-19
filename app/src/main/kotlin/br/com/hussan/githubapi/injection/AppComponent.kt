package br.com.hussan.githubapi.injection

import android.app.Application
import br.com.hussan.githubapi.AppApplication
import br.com.hussan.githubapi.app.injection.module.DataModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
    ApiModule::class,
    AppModule::class,
    DBModule::class,
    DataModule::class,
    ActivityModule::class
])
interface AppComponent: AndroidInjector<AppApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    override fun inject(app: AppApplication)
}