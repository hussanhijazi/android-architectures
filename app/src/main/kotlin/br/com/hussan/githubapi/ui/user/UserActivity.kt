

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
import javax.inject.Inject

class UserActivity : AppCompatActivity(), Injectable {

    @Suppress("LateinitUsage")
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    companion object {
        private val TAG = UserActivity::class.java.simpleName
    }

    @Suppress("LateinitUsage")
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

        val repo = viewModel.getUser(userName)

        repo.observe(this, Observer {
            this.user_name.text  = it?.data?.login?:return@Observer
        })
    }

    override fun onStop() {
        super.onStop()
        disposable.clear()
    }
}
