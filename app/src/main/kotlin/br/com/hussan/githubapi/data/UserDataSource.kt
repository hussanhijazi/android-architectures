package br.com.hussan.githubapi.data

import br.com.hussan.githubapi.data.local.PreferencesDataSource
import br.com.hussan.githubapi.data.local.db.UserDao
import br.com.hussan.githubapi.data.model.User
import br.com.hussan.githubapi.data.remote.AppApi
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable

interface UserDataSource {
    fun getLastQuery(): Flowable<String>
    fun insertUser(user: User): Completable
    fun getUser(login: String): Observable<User>
}
class UserRepository(private val appApi: AppApi,
                     val userDao: UserDao,
                     private val preferencesDataSource: PreferencesDataSource): UserDataSource
{
    override fun getUser(login: String): Observable<User> =
            appApi.getUser(login).doOnNext {
                preferencesDataSource.storeUser(it.login)
            }

    override fun insertUser(user: User): Completable =
            Completable.create { userDao.insertUser(user) }

    override fun getLastQuery(): Flowable<String> {
        return userDao.getLastQuery()
                .map { user -> user.login }
    }

}