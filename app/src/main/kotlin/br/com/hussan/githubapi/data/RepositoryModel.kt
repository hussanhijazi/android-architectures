package br.com.hussan.githubapi.data

import br.com.hussan.githubapi.data.api.ApiInterface
import br.com.hussan.githubapi.data.model.Repository
import rx.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by hussan on 10/17/16.
 */
@Singleton
class RepositoryModel @Inject constructor(val apiService: ApiInterface) {
    fun getAllRepositories(): Observable<List<Repository>>
    {
        return apiService!!.repositories("helabs")

//        return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe { repositories ->
//            mAdapter!!.setItems(repositories)
//            mProgress!!.visibility = View.GONE
//            mRecyclerView!!.visibility = View.VISIBLE
//        }
    }
}
