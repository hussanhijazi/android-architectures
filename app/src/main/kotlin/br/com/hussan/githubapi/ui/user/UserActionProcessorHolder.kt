package br.com.hussan.githubapi.ui.user

import br.com.hussan.githubapi.data.SchedulerProviderContract
import br.com.hussan.githubapi.data.UserDataSource
import br.com.hussan.githubapi.data.model.User
import io.reactivex.Observable
import io.reactivex.ObservableTransformer

class UserActionProcessorHolder(
    private val dataSource: UserDataSource,
    private val schedulerProvider: SchedulerProviderContract
) {
    internal var actionProcessor =
        ObservableTransformer<UserAction, UserResult> { actions ->
            actions.publish { shared ->
                Observable.merge(
                    // Match LoadTasksAction to loadTasksProcessor
                    shared.ofType(UserAction.InitialAction::class.java).compose(loadUserProcessor),
                    shared.ofType(UserAction.InsertUser::class.java).compose(insertUser))
                    .mergeWith(
                        // Error for not implemented actions
                        shared.filter { v ->
                            v !is UserAction.InitialAction
                                    && v !is UserAction.GetUser
                                    && v !is UserAction.InsertUser
                        }.flatMap { w ->
                            Observable.error<UserResult>(
                                IllegalArgumentException("Unknown Action type: $w"))
                        }
                    )
            }
        }

    val loadUserProcessor =
        ObservableTransformer<UserAction, UserResult.LoadUserResult> { actions ->
            actions.flatMap { action ->
                dataSource.getLastQuery()
                    // Transform the Single to an Observable to allow emission of multiple
                    // events down the stream (e.g. the InFlight event)
                    .toObservable()
                    // Wrap returned data into an immutable object
                    .map { user ->
                        UserResult.LoadUserResult.Success(User(user))
                    }
                    .cast(UserResult.LoadUserResult::class.java)
                    // Wrap any error into an immutable object and pass it down the stream
                    // without crashing.
                    // Because errors are data and hence, should just be part of the stream.
                    .onErrorReturn(UserResult.LoadUserResult::Failure)
                    .subscribeOn(schedulerProvider.io)
                    .observeOn(schedulerProvider.ui)
                    // Emit an InFlight event to notify the subscribers (e.g. the UI) we are
                    // doing work and waiting on a response.
                    // We emit it after observing on the UI thread to allow the event to be emitted
                    // on the current frame and avoid jank.
                    .startWith(UserResult.LoadUserResult.InFlight)

            }
        }

     val insertUser =
        ObservableTransformer<UserAction.InsertUser, UserResult> { actions ->
            actions.flatMap { action ->
                dataSource.insertUser(User(action.name))
                    .map { user ->
                        UserResult.LoadUserResult.Success(User(action.name))
                    }
                    .cast(UserResult.LoadUserResult::class.java)
                     .onErrorReturn(UserResult.LoadUserResult::Failure)
                    .subscribeOn(schedulerProvider.io)
                    .observeOn(schedulerProvider.ui)
            }
        }

}