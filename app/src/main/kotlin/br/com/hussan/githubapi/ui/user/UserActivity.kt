

package br.com.hussan.githubapi.ui.user

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.hussan.githubapi.BaseView
import br.com.hussan.githubapi.R
import br.com.hussan.githubapi.injection.Injectable
import dagger.android.AndroidInjection
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_user.*
import javax.inject.Inject

class UserActivity : AppCompatActivity(), Injectable, BaseView<UserIntent, UserViewState> {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    companion object {
        private val TAG = UserActivity::class.java.simpleName
    }

    private lateinit var viewModel: UserViewModel

    private val disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        AndroidInjection.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel::class.java)

        update.setOnClickListener {
            getGitHubUser()
        }
    }
    override fun intents(): Observable<UserIntent> {
        return Observable.merge(initialIntent(),
            getUserIntent())
    }

    /**
     * The initial Intent the [BaseView] emit to convey to the [BaseViewModel]
     * that it is ready to receive data.
     * This initial Intent is also used to pass any parameters the [BaseViewModel] might need
     * to render the initial [BaseViewState] (e.g. the task id to load).
     */
    private fun initialIntent(): Observable<UserIntent.InitialIntent> {
        return Observable.just(UserIntent.InitialIntent)
    }
    private fun getUserIntent(): Observable<UserIntent.GetUser> {
        return Observable.just(UserIntent.GetUser)
    }
    override fun render(state: UserViewState) {
    }
    private fun getGitHubUser() {
        val userName = user_name_input.text.toString()

        disposable.add(viewModel.states().subscribe(this::render))
        viewModel.processIntents(intents())


//        disposable.add(
//                viewModel.getUser(userName)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnNext { viewModel.updateUserName(it.login)}
//                .subscribe({ this.user_name.text  = it.login},
//                        { error -> Log.e(TAG, "Unable to get username", error) })
//        )

    }

    override fun onStart() {
        super.onStart()

//        disposable.add(viewModel.getLastQuery()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ this.user_name.text = it },
//                        { error -> Log.e(TAG, "Unable to get username", error) }))
    }

    override fun onStop() {
        super.onStop()
        disposable.clear()
    }

    private fun updateUserName() {
        val userName = user_name_input.text.toString()
        update.isEnabled = false
//        viewModel.updateUserName(userName)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ update.isEnabled = true },
//                        { error -> Log.e(TAG, "Unable to update username", error) })
//                .addToCompositeDisposable(disposable)
    }

}
