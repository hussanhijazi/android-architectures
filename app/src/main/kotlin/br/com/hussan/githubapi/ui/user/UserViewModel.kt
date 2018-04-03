

package br.com.hussan.githubapi.ui.user

import android.arch.lifecycle.ViewModel
import android.util.Log
import br.com.hussan.githubapi.BaseViewModel
import br.com.hussan.githubapi.BaseViewState
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class UserViewModel
        @Inject constructor(private val actionProcessorHolder: UserActionProcessorHolder) : ViewModel(),
    BaseViewModel<UserIntent, UserViewState> {

    private val intentsSubject: PublishSubject<UserIntent> = PublishSubject.create()
    private val statesObservable: Observable<UserViewState> = compose()

    override fun processIntents(intents: Observable<UserIntent>) {
        intents.subscribe(intentsSubject)
    }

    override fun states(): Observable<UserViewState> {
        return statesObservable
    }
    private fun compose(): Observable<UserViewState> {
        return intentsSubject
            .map(this::actionFromIntent)
            .compose(actionProcessorHolder.actionProcessor)
            // Cache each state and pass it to the reducer to create a new state from
            // the previous cached one and the latest Result emitted from the action processor.
            // The Scan operator is used here for the caching.
            .scan(UserViewState.idle(), reducer)
            // When a reducer just emits previousState, there's no reason to call render. In fact,
            // redrawing the UI in cases like this can cause jank (e.g. messing up snackbar animations
            // by showing the same snackbar twice in rapid succession).
            .distinctUntilChanged()
            // Emit the last one event of the stream on subscription
            // Useful when a View rebinds to the ViewModel after rotation.
            .replay(1)
            // Create the stream on creation without waiting for anyone to subscribe
            // This allows the stream to stay alive even when the UI disconnects and
            // match the stream's lifecycle to the ViewModel's one.
            .autoConnect(0)

    }
    private fun actionFromIntent(intent: UserIntent): UserAction {
        return when (intent) {
            is UserIntent.InitialIntent -> UserAction.InitialAction
            is UserIntent.GetUser -> UserAction.GetUser(intent.name)
            is UserIntent.InsertUser -> UserAction.InsertUser(intent.name)
        }
    }

    companion object {
        /**
         * The Reducer is where [BaseViewState], that the [BaseView] will use to
         * render itself, are created.
         * It takes the last cached [BaseViewState], the latest [BaseResult] and
         * creates a new [BaseViewState] by only updating the related fields.
         * This is basically like a big switch statement of all possible types for the [BaseResult]
         */
        private val reducer = BiFunction { previousState: UserViewState, result: UserResult ->
            Log.d("h2-", previousState.toString())
            when (result) {
                is UserResult.LoadUserResult -> when (result) {
                    is UserResult.LoadUserResult.Success -> {
                        previousState.copy(
                            isLoading = false,
                            user = result.user
                        )
                    }
                    is UserResult.LoadUserResult.Failure -> previousState.copy(
                        isLoading = false,
                        error = result.error
                    )
                    is UserResult.LoadUserResult.InFlight -> previousState.copy(isLoading = true)
                }
            }

        }
    }
//    fun getLastQuery(): Flowable<String> = dataSource.getLastQuery()
//
//    fun updateUserName(userName: String): Completable {
//        val user = User(userName)
//        return dataSource.insertUser(user)
//    }
//
//    fun getUser(login: String): Observable<User> = dataSource.getUser(login)

}
