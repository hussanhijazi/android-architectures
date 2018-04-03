package br.com.hussan.githubapi.ui.user

import br.com.hussan.githubapi.BaseIntent

sealed class UserIntent : BaseIntent{
    object InitialIntent : UserIntent()
    object GetUser : UserIntent()

//    data class RefreshIntent(val forceUpdate: Boolean) : UserIntent()
//
//    data class ActivateTaskIntent(val task: User) : UserIntent()
//
//    data class CompleteTaskIntent(val task: User) : UserIntent()
//
//    object ClearCompletedTasksIntent : UserIntent()

//    data class ChangeFilterIntent(val filterType: TasksFilterType) : UserIntent()
}