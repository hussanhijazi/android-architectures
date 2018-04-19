package br.com.hussan.githubapi

import br.com.hussan.githubapi.data.UserDataSource
import br.com.hussan.githubapi.data.local.PreferencesDataSource
import br.com.hussan.githubapi.ui.user.UserViewModel
import org.junit.Before
import org.junit.Test

@Suppress("IllegalIdentifier")
class UserViewModelTest {

    lateinit var dataSource: UserDataSource
    lateinit var viewModel: UserViewModel
    lateinit var preferencesDataSource: PreferencesDataSource

    @Before fun setUp() {

        dataSource = mock()
        preferencesDataSource = mock()
        viewModel = UserViewModel(dataSource)
    }
    @Test
    fun `get github username`()
    {
//        val login = "login"
//        val user = User(login)
//
//        `when`(dataSource.getUser(login)).thenReturn(Observable.just(user))
//
//        viewModel.getUser(login)
//                .test()
//                .assertValue(user)
//
//        verify(dataSource).getUser(login)
    }
    @Test
    fun `not get github username`()
    {
//        val login = "login"
//        `when`(dataSource.getUser(login)).thenReturn(Observable.empty())
//
//        viewModel.getUser(login)
//                .test()
//                .assertNoErrors()
//                .assertComplete()
//
//        verify(dataSource).getUser(login)
    }

}