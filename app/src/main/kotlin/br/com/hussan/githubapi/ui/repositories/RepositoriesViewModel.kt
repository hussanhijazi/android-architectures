package br.com.hussan.githubapi.ui.repositories

import br.com.hussan.githubapi.data.RepositoryDataSource
import br.com.hussan.githubapi.data.model.Repository
import io.reactivex.Observable


class RepositoriesViewModel(var model: RepositoryDataSource) {

    fun getAllRepositories(): Observable<List<Repository>> = model.getAllRepositories()

}
