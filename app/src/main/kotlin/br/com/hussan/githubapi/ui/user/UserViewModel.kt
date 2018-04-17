

package br.com.hussan.githubapi.ui.user

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.hussan.githubapi.data.UserDataSource
import br.com.hussan.githubapi.data.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserViewModel
        @Inject constructor(private val dataSource: UserDataSource) : ViewModel() {

    var user = MutableLiveData<User>()

//    init {
//         dataSource.getUser("google")
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe {
//                user.value = it
//            }
//    }
//    fun getLastQuery(): Flowable<String> = dataSource.getLastQuery()
//
//    fun updateUserName(userName: String): Completable {
//        val user = User(userName)
//        return dataSource.insertUser(user)
//    }
//
    fun getUser(login: String){
       dataSource.getUser(login)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                user.value = it
            }
    }

}
