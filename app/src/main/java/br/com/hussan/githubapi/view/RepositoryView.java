package br.com.hussan.githubapi.view;

import java.util.List;

import br.com.hussan.githubapi.data.models.Repository;

/**
 * Created by hussan on 7/22/16.
 */

public interface RepositoryView {
    void setRepositories(List<Repository> repositories);
}
