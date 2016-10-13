package br.com.hussan.githubapi.ui.repositories

import android.graphics.PorterDuff
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import br.com.hussan.githubapi.GithubApp
import br.com.hussan.githubapi.R
import br.com.hussan.githubapi.adapters.RepositoryAdapter
import br.com.hussan.githubapi.data.api.ApiInterface
import br.com.hussan.githubapi.data.model.Repository
import br.com.hussan.githubapi.databinding.ListItemBinding
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : AppCompatActivity(), RepositoryAdapter.ClickItem, RepositoriesContract.View {

    @Inject
    lateinit var apiService: ApiInterface

    @Inject
    lateinit var presenter: RepositoriesPresenter

    private var mRecyclerView: RecyclerView? = null
    private var mProgress: ProgressBar? = null
    private var mAdapter: RepositoryAdapter? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as GithubApp).component.inject(this)

        initUI()
        callApi()

    }

    private fun initUI() {
        mRecyclerView = findViewById(R.id.list_repos) as RecyclerView

        mProgress = findViewById(R.id.progress) as ProgressBar
        mProgress!!.indeterminateDrawable.setColorFilter(ContextCompat.getColor(this, R.color.colorPrimary), PorterDuff.Mode.MULTIPLY)


        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView!!.setHasFixedSize(true)

        // use a linear layout manager
        mLayoutManager = LinearLayoutManager(this)
        mRecyclerView!!.layoutManager = mLayoutManager

        mAdapter = RepositoryAdapter()
        mAdapter!!.clickListener = this
        mRecyclerView!!.adapter = mAdapter
    }

    private fun callApi() {
        val observable = apiService!!.repositories("helabs")

        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe { repositories ->
            mAdapter!!.setItems(repositories)
            mProgress!!.visibility = View.GONE
            mRecyclerView!!.visibility = View.VISIBLE
        }

    }
    override fun setRepositories(repositories: List<Repository>) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun onClick(binding: ListItemBinding) {
//        Log.d("h2", "click" + binding.repo.name!!)
    }
}
