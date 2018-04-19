package br.com.hussan.githubapi.ui.repositories

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import br.com.hussan.githubapi.R
import br.com.hussan.githubapi.data.model.Repo
import br.com.hussan.githubapi.injection.Injectable
import dagger.android.AndroidInjection
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_repos.view.*
import javax.inject.Inject


class RepositoriesActivity: AppCompatActivity(), Injectable {

    @Suppress("LateinitUsage")
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Suppress("LateinitUsage")
    private lateinit var viewModel: RepositoriesViewModel
    @Suppress("LateinitUsage")
    lateinit var binding: ViewDataBinding

    private val TAG = RepositoriesActivity::class.java.simpleName

    private var mRecyclerView: RecyclerView? = null
    private var mProgress: ProgressBar? = null
    private var mAdapter: RepositoryAdapter? = null

    private val mDisposable = CompositeDisposable()

    companion object {
        val NAME = "NAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        AndroidInjection.inject(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(RepositoriesViewModel::class.java)

        binding = DataBindingUtil.setContentView<ViewDataBinding>(this, R.layout.activity_repos)

        initUI()

        viewModel.setQuery("helabs")

        viewModel.results.observe(this, Observer {
            if(it?.data?.isNotEmpty() == true) {
                setRepositories(it?.data)
            }
        })
    }

    private fun initUI() {
        mRecyclerView = binding.root.list_repos
        mAdapter = RepositoryAdapter()

        mProgress = binding.root.progress

        mRecyclerView?.apply{
            setHasFixedSize(true)
            adapter = mAdapter
        }

    }

    private fun setRepositories(repositories: List<Repo>) {
        mAdapter?.setItems(repositories)
        mProgress?.visibility = View.GONE
        mRecyclerView?.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        mDisposable.dispose()
    }
}
