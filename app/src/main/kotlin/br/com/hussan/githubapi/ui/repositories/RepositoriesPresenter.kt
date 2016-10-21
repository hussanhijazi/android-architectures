package br.com.hussan.githubapi.ui.repositories

import android.util.Log
import br.com.hussan.githubapi.data.model.Repository
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by hussan on 10/11/16.
 */
class RepositoriesPresenter(val mView: RepositoriesContract.View, val mModel: RepositoryModel): RepositoriesContract.Presenter{
    override fun getAllRepositories() {
        var repositories: Observable<List<Repository>> = mModel.getAllRepositories()
        repositories.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe { repositories ->
            mView.setRepositories(repositories)
            Log.d("h2", "getAllRepos")
        }
    }

}
