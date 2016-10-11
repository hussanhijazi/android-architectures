package br.com.hussan.githubapi.contracts;

import java.util.List;

import br.com.hussan.githubapi.data.models.Repository;
import br.com.hussan.githubapi.model.BaseModel;
import br.com.hussan.githubapi.presenter.BasePresenter;

/**
 * Created by hussan on 7/22/16.
 */

public interface RepositoryContract {

    interface Model extends BaseModel {
        void getAllRepositories();
    }

    interface Presenter extends BasePresenter {
        void getAllRepositories();

        void setRepositories(List<Repository> repositories);
    }

}
