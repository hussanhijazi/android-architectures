package br.com.hussan.githubapi.ui.repositories.ui

import br.com.hussan.githubapi.BaseView
import br.com.hussan.githubapi.ui.repositories.RepositoriesContract
import br.com.hussan.githubapi.ui.repositories.RepositoriesPresenter
import br.com.hussan.githubapi.ui.repositories.RepositoryModel
import dagger.Module
import dagger.Provides

/**
 * Created by hussan on 10/18/16.
 */
@Module
open class PresenterModule(private val view: BaseView) {

    @Provides
    @PerActivity
    fun providesRepositoriesPresenter(repositoryModel: RepositoryModel): RepositoriesContract.Presenter {
        if (view !is RepositoriesContract.View) {
            throw AssertionError("Wrong view for presenter")
        }

        return RepositoriesPresenter(view, repositoryModel)
    }

}