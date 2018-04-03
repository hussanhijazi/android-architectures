package br.com.hussan.githubapi.ui.user

import br.com.hussan.githubapi.BaseSchedulerProvider
import br.com.hussan.githubapi.data.UserDataSource
import br.com.hussan.githubapi.data.model.User
import io.reactivex.ObservableTransformer

class UserActionProcessorHolder(
    private val dataSource: UserDataSource,
    private val schedulerProvider: BaseSchedulerProvider
) {

    internal val loadUserProcessor =
        ObservableTransformer<UserAction, UserResult.LoadUserResult> { actions ->
            actions.flatMap { action ->
                dataSource.getLastQuery()
                    // Transform the Single to an Observable to allow emission of multiple
                    // events down the stream (e.g. the InFlight event)
                    .toObservable()
                    // Wrap returned data into an immutable object
                    .map { user -> UserResult.LoadUserResult.Success(User(user)) }
                    .cast(UserResult.LoadUserResult::class.java)
                    // Wrap any error into an immutable object and pass it down the stream
                    // without crashing.
                    // Because errors are data and hence, should just be part of the stream.
                    .onErrorReturn(UserResult.LoadUserResult::Failure)
                    .subscribeOn(schedulerProvider.io())
                    .observeOn(schedulerProvider.ui())
                    // Emit an InFlight event to notify the subscribers (e.g. the UI) we are
                    // doing work and waiting on a response.
                    // We emit it after observing on the UI thread to allow the event to be emitted
                    // on the current frame and avoid jank.
                    .startWith(UserResult.LoadUserResult.InFlight)
            }
        }

}