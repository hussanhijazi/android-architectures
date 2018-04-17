package br.com.hussan.githubapi.data.remote

import android.arch.lifecycle.LiveData
import br.com.hussan.githubapi.data.ApiResponse
import br.com.hussan.githubapi.data.model.Repo
import br.com.hussan.githubapi.data.model.User
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * REST API access points
 */
interface AppApi {
    @GET("/users/{login}")
    fun getUser(@Path("login") login: String): LiveData<ApiResponse<User>>

    @GET("/users/{login}/repos")
    fun getRepositories(@Path("login") login: String): LiveData<ApiResponse<List<Repo>>>
}
