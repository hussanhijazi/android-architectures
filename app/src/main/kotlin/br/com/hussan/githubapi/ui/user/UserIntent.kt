package br.com.hussan.githubapi.ui.user

import br.com.hussan.githubapi.BaseIntent

sealed class UserIntent : BaseIntent{
    object InitialIntent : UserIntent()
    data class GetUser(val name: String) : UserIntent()
    data class InsertUser(val name: String) : UserIntent()

}