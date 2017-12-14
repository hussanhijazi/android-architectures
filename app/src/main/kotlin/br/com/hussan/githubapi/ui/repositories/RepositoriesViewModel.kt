package br.com.hussan.githubapi.ui.repositories

import br.com.hussan.githubapi.data.RepositoryModel
import br.com.hussan.githubapi.data.model.Repository
import rx.Observable

class RepositoriesViewModel{
    val model: RepositoryModel by lazy{
        RepositoryModel()
    }
    fun getAllRepositories(): Observable<List<Repository>>  = model.getAllRepositories()

}
