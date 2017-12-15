package br.com.hussan.retrofitgithubapi

import br.com.hussan.githubapi.data.RepositoryDataSource
import br.com.hussan.githubapi.data.model.Repository
import br.com.hussan.githubapi.ui.repositories.RepositoriesViewModel
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`

@Suppress("IllegalIdentifier")
class RepositoriesViewModelTest {

    @Mock
    lateinit var model: RepositoryDataSource

    lateinit var viewModel: RepositoriesViewModel

    @Before
    fun setup()
    {
        model = mock()

        viewModel = RepositoriesViewModel(model)
    }

    @Test
    fun `get repositories emit correct values`(){

        val repositories = listOf(Repository(name = "Test"), Repository(name = "Test2"))

        `when`(model.getAllRepositories()).thenReturn(Observable.just(repositories))

       viewModel.getAllRepositories()
                .test()
                .assertNoErrors()
                .assertComplete()
                .assertValue(repositories)

    }
}
