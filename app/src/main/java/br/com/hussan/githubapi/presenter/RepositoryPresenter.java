package br.com.hussan.githubapi.presenter;

import java.util.List;

import br.com.hussan.githubapi.data.models.Repository;
import br.com.hussan.githubapi.contracts.RepositoryContract;
import br.com.hussan.githubapi.model.RepositoryModel;
import br.com.hussan.githubapi.view.RepositoryView;

/**
 * Created by hussan on 7/22/16.
 */

public class RepositoryPresenter implements RepositoryContract.Presenter {

    private final RepositoryView mView;
    private final RepositoryModel mModel;

    public RepositoryPresenter(RepositoryView mView) {
        this.mView = mView;
        this.mModel = new RepositoryModel(this);
    }

    public RepositoryPresenter(RepositoryView mView, RepositoryModel mModel) {
        mModel.setPresenter(this);
        this.mView = mView;
        this.mModel = mModel;
    }

    public void getAllRepositories() {
        mModel.getAllRepositories();
    }

    public void setRepositories(List<Repository> repositories) {
        mView.setRepositories(repositories);
    }
}
