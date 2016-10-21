package br.com.hussan.githubapi.ui.repositories

import br.com.hussan.githubapi.BasePresenter
import br.com.hussan.githubapi.BaseView
import br.com.hussan.githubapi.data.model.Repository

/**
 * Created by hussan on 10/11/16.
 */
interface RepositoriesContract{
    interface View: BaseView{
        fun setRepositories(repositories: List<Repository>)
    }
    interface Presenter:BasePresenter{
        fun getAllRepositories()
    }
}

