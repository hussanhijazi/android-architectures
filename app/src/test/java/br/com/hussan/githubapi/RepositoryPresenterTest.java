package br.com.hussan.githubapi;

import org.junit.Before;

import br.com.hussan.githubapi.model.RepositoryModel;
import br.com.hussan.githubapi.presenter.RepositoryPresenter;
import br.com.hussan.githubapi.view.RepositoryView;

import static org.mockito.Mockito.mock;

/**
 * Created by hussan on 7/22/16.
 */
public class RepositoryPresenterTest {

    RepositoryView mView;
    RepositoryModel mModel;
    RepositoryPresenter mPresenter;

    @Before
    public void init() {
        mView = mock(RepositoryView.class);
        mModel = mock(RepositoryModel.class);
        mPresenter = new RepositoryPresenter(mView, mModel);
    }
}
