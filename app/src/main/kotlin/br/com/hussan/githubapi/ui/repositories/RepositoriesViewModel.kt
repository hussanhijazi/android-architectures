package br.com.hussan.githubapi.ui.repositories

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import br.com.hussan.githubapi.data.AbsentLiveData
import br.com.hussan.githubapi.data.RepoDataSource
import br.com.hussan.githubapi.data.model.Repo
import br.com.hussan.githubapi.data.model.Resource
import java.util.*
import javax.inject.Inject

class RepositoriesViewModel
        @Inject constructor(private val dataSource: RepoDataSource) : ViewModel() {

    var results: LiveData<Resource<List<Repo>>>
    val login = MutableLiveData<String>()

    init{
        results = Transformations.switchMap(login, {
            when {
                it == null || it.length == 1 -> AbsentLiveData.create()
                else -> dataSource.getRepositories(it)
            }
        })
    }
    fun setQuery(originalInput: String?, force:Boolean = false) {
        if(originalInput == null) return
        val input = originalInput.toLowerCase(Locale.getDefault()).trim { it <= ' ' }
        if (input == login.value && !force) {
            return
        }
        login.value = input
    }
}
