package br.com.hussan.githubapi.data

import br.com.hussan.githubapi.AppExecutors
import br.com.hussan.githubapi.data.local.PreferencesDataSource
import br.com.hussan.githubapi.data.local.db.UserDao
import br.com.hussan.githubapi.data.model.User
import br.com.hussan.githubapi.data.remote.AppApi
import io.reactivex.Completable
import io.reactivex.Flowable
import android.arch.lifecycle.LiveData
import br.com.hussan.githubapi.data.model.Resource


interface UserDataSource {
    fun getLastQuery(): Flowable<String>
    fun insertUser(user: User): Completable
    fun getUser(login: String): LiveData<Resource<User>>
}
class UserRepository(private val appApi: AppApi,
                     private val userDao: UserDao,
                     private val preferencesDataSource: PreferencesDataSource,
                     private val appExecutors: AppExecutors): UserDataSource
{

    override fun getUser(login: String): LiveData<Resource<User>> {
        return object : NetworkBoundResource<User, User>(appExecutors) {
            override fun saveCallResult(item: User) {
                userDao.insertUser(item)
            }
            override fun shouldFetch(data: User?): Boolean {
                return data == null
            }
            override fun loadFromDb(): LiveData<User> {
                return userDao.findByLogin(login)
            }
            override fun createCall(): LiveData<ApiResponse<User>> {
                return appApi.getUser(login)
            }
        }.asLiveData()
    }
    override fun insertUser(user: User): Completable =
            Completable.create { userDao.insertUser(user) }

    override fun getLastQuery(): Flowable<String> {
        return userDao.getLastQuery()
                .map { user -> user.login }
    }

}