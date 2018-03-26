

package br.com.hussan.githubapi.data.remote

import br.com.hussan.githubapi.data.model.User
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * REST API access points
 */
interface AppApi {
    @GET("users/{login}")
    fun getUser(@Path("login") login: String): Observable<User>

}
