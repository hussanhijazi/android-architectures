package br.com.hussan.githubapi

import br.com.hussan.githubapi.data.UserDataSource
import br.com.hussan.githubapi.data.local.PreferencesDataSource
import br.com.hussan.githubapi.data.local.db.UserDao
import br.com.hussan.githubapi.data.remote.AppApi
import org.junit.Before
import org.junit.Test

@Suppress("IllegalIdentifier")
class UserDataSourceTest {

    lateinit var dataSource: UserDataSource
    lateinit var preferencesDataSource: PreferencesDataSource
    lateinit var appApi: AppApi
    lateinit var userDao: UserDao

    @Before
    fun setUp() {
        preferencesDataSource = mock()
        appApi = mock()
        userDao = mock()

//        dataSource = UserRepository(appApi, userDao, preferencesDataSource)
    }
    @Test
    fun `get github username`()
    {
//        val login = "login"
//        val user = User(login)
//        `when`(appApi.getUser(login)).thenReturn(Observable.just(user))
//
//        dataSource.getUser(login)
//                .test()
//                .assertValue(user)
//                .assertNoErrors()
//                .assertComplete()
//
//        verify(preferencesDataSource).storeUser(user.login)

    }
    @Test
    fun `not get github username`()
    {
//        val login = "login"
//        `when`(appApi.getUser(login)).thenReturn(Observable.empty())
//
//        dataSource.getUser(login)
//                .test()
//                .assertNoErrors()
//                .assertComplete()
//
//        verifyNoMoreInteractions(preferencesDataSource)
    }

}