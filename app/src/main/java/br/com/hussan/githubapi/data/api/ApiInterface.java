package br.com.hussan.githubapi.data.api;

import java.util.List;

import br.com.hussan.githubapi.data.models.Repository;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by hussan on 4/11/16.
 */
public interface ApiInterface {

    @GET("/users/{user}/repos?sort=pushed")
    Observable<List<Repository>> getRepositories(
            @Path("user") String user
    );
}
