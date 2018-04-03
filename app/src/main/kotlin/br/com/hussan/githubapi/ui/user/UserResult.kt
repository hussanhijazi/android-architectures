package br.com.hussan.githubapi.ui.user

import br.com.hussan.githubapi.BaseResult
import br.com.hussan.githubapi.data.model.User

sealed class UserResult : BaseResult{
    sealed class LoadUserResult : UserResult() {
        data class Success(val user: User) : LoadUserResult()
        data class Failure(val error: Throwable) : LoadUserResult()
        object InFlight : LoadUserResult()
    }

}