

package br.com.hussan.githubapi.ui.user

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.hussan.githubapi.R
import br.com.hussan.githubapi.injection.Injectable
import dagger.android.AndroidInjection
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_user.*
import timber.log.Timber
import javax.inject.Inject

class UserActivity : AppCompatActivity(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    companion object {
        private val TAG = UserActivity::class.java.simpleName
    }

    private val viewModel: UserViewModel by lazy{
        ViewModelProviders.of(this, viewModelFactory).get(UserViewModel::class.java)
    }

    private val disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        AndroidInjection.inject(this)

        with(viewModel) {
            user?.observe(this@UserActivity, Observer {
                it?.let { result ->
                    user_name.text  = it.login
                    Timber.i(result.toString())
                }
            })
        }
        update.setOnClickListener {
            viewModel.getUser(user_name_input.text.toString())
        }
    }

    private fun getGitHubUser() {
        val userName = user_name_input.text.toString()



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
