package br.com.hussan.githubapi.injection

import br.com.hussan.githubapi.ui.repositories.RepositoriesActivity
import br.com.hussan.githubapi.ui.user.UserActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): UserActivity
    @ContributesAndroidInjector
    internal abstract fun contributeRepositoriesActivity(): RepositoriesActivity
}
