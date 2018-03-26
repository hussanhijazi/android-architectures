package br.com.hussan.githubapi.injection

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

import br.com.hussan.githubapi.ui.user.UserViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    internal abstract fun bindUserViewModel(userViewModel: UserViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
