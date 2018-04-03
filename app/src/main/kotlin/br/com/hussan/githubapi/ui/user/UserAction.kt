package br.com.hussan.githubapi.ui.user

import br.com.hussan.githubapi.BaseAction

sealed class UserAction : BaseAction{
    class GetUser : UserAction()
    class InitialAction: UserAction()

}