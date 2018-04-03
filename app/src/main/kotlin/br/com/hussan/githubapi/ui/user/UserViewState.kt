package br.com.hussan.githubapi.ui.user

import br.com.hussan.githubapi.BaseViewState
import br.com.hussan.githubapi.data.model.User

data class UserViewState(
    val isLoading: Boolean,
    val user: User?,
    val error: Throwable?
) : BaseViewState {
    companion object {
        fun idle(): UserViewState {
            return UserViewState(
                isLoading = false,
                user = null,
                error = null
            )
        }
    }
}