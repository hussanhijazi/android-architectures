package br.com.hussan.githubapi.data

import android.arch.lifecycle.LiveData
import br.com.hussan.githubapi.AppExecutors
import br.com.hussan.githubapi.data.local.db.RepoDao
import br.com.hussan.githubapi.data.model.Repo
import br.com.hussan.githubapi.data.model.Resource
import br.com.hussan.githubapi.data.remote.AppApi


interface RepoDataSource {
    fun getRepositories(login: String): LiveData<Resource<List<Repo>>>
}
class RepoRespository(private val appApi: AppApi,
                      private val repoDao: RepoDao,
                      private val appExecutors: AppExecutors): RepoDataSource
{
    override fun getRepositories(login: String): LiveData<Resource<List<Repo>>>
    {
        return object : NetworkBoundResource<List<Repo>, List<Repo>>(appExecutors) {
            override fun saveCallResult(item: List<Repo>) {
                repoDao.insertRepos(item)
            }
            override fun shouldFetch(data: List<Repo>?): Boolean {
                return true
            }
            override fun loadFromDb(): LiveData<List<Repo>> {
                return repoDao.loadRepositories(login)
            }
            override fun createCall(): LiveData<ApiResponse<List<Repo>>> {
                return appApi.getRepositories(login)
            }
        }.asLiveData()
    }
}