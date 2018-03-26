

package br.com.hussan.githubapi.injection

import br.com.hussan.githubapi.ui.user.UserActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): UserActivity
}
