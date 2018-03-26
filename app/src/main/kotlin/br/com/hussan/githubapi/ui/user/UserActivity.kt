

package br.com.hussan.githubapi.ui.user

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import br.com.hussan.githubapi.R
import br.com.hussan.githubapi.extensions.addToCompositeDisposable
import br.com.hussan.githubapi.injection.Injectable
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_user.*
import javax.inject.Inject

class UserActivity : AppCompatActivity(), Injectable {

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

        update.setOnClickListener { getGitHubUser() }
    }

    private fun getGitHubUser() {
        val userName = user_name_input.text.toString()

        disposable.add(
                viewModel.getUser(userName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext { viewModel.updateUserName(it.login)}
                .subscribe({ this.user_name.text  = it.login},
                        { error -> Log.e(TAG, "Unable to get username", error) })
        )

    }

    override fun onStart() {
        super.onStart()

        disposable.add(viewModel.getLastQuery()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ this.user_name.text = it },
                        { error -> Log.e(TAG, "Unable to get username", error) }))
    }

    override fun onStop() {
        super.onStop()
        disposable.clear()
    }

    private fun updateUserName() {
        val userName = user_name_input.text.toString()
        update.isEnabled = false
        viewModel.updateUserName(userName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ update.isEnabled = true },
                        { error -> Log.e(TAG, "Unable to update username", error) })
                .addToCompositeDisposable(disposable)
    }

}
