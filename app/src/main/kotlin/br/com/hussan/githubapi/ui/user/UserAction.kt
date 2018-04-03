package br.com.hussan.githubapi.ui.user

import br.com.hussan.githubapi.BaseAction

sealed class UserAction : BaseAction{
    data class GetUser(val name: String) : UserAction()
    data class InsertUser(val name: String) : UserAction()
    object InitialAction: UserAction()
}
