package br.com.hussan.githubapi.data.api

import br.com.hussan.githubapi.data.model.Repository
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by hussan on 4/11/16.
 */
interface ApiInterface {

    @GET("/users/{user}/repos")
    fun repositories(
            @Path("user") user: String): Observable<List<Repository>>
}
