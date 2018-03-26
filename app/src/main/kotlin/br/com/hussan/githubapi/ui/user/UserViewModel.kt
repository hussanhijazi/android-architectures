

package br.com.hussan.githubapi.ui.user

import android.arch.lifecycle.ViewModel
import br.com.hussan.githubapi.data.UserDataSource
import br.com.hussan.githubapi.data.model.User
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

class UserViewModel
        @Inject constructor(private val dataSource: UserDataSource) : ViewModel() {

    fun getLastQuery(): Flowable<String> = dataSource.getLastQuery()
    
    fun updateUserName(userName: String): Completable {
        val user = User(userName)
        return dataSource.insertUser(user)
    }

    fun getUser(login: String): Observable<User> = dataSource.getUser(login)

}
