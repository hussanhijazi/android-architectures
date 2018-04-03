

package br.com.hussan.githubapi.ui.user

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import br.com.hussan.githubapi.BaseView
import br.com.hussan.githubapi.R
import br.com.hussan.githubapi.injection.Injectable
import com.jakewharton.rxbinding2.view.RxView
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

        disposable.add(viewModel.states().subscribe(this::render))
        viewModel.processIntents(intents())
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
    private fun getUserIntent(): Observable<UserIntent.InsertUser> {
        return RxView.clicks(update).map {
            UserIntent.InsertUser(user_name_input.text.toString())
        }
    }
    override fun render(state: UserViewState) {
        Log.d("h222", state.toString())
        state.user?.let{
            user_name.text = it.login
        }
    }
    override fun onStop() {
        super.onStop()
        disposable.clear()
    }

}
