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
import br.com.hussan.githubapi.data.model.Repository
import br.com.hussan.githubapi.databinding.ListItemBinding
import br.com.hussan.githubapi.injection.ui.PresenterModule
import br.com.hussan.githubapi.injection.ui.UiComponent
import javax.inject.Inject

class RepositoriesActivity : AppCompatActivity(), RepositoryAdapter.ClickItem, RepositoriesContract.View {

    @Inject
    lateinit var presenter: RepositoriesContract.Presenter

    private var mRecyclerView: RecyclerView? = null
    private var mProgress: ProgressBar? = null
    private var mAdapter: RepositoryAdapter? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null

    lateinit var uiComponent: UiComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        uiComponent = (application as GithubApp).component.plus(PresenterModule(this))

        super.onCreate(savedInstanceState)

        uiComponent.inject(this)

        setContentView(R.layout.activity_main)

        initUI()

        presenter.getAllRepositories()

    }

    private fun initUI() {
        mRecyclerView = findViewById(R.id.list_repos) as RecyclerView

        mProgress = findViewById(R.id.progress) as ProgressBar
        mProgress!!.indeterminateDrawable.setColorFilter(ContextCompat.getColor(this, R.color.colorPrimary), PorterDuff.Mode.MULTIPLY)


        mRecyclerView!!.setHasFixedSize(true)

        mLayoutManager = LinearLayoutManager(this)
        mRecyclerView!!.layoutManager = mLayoutManager

        mAdapter = RepositoryAdapter()
        mAdapter!!.clickListener = this
        mRecyclerView!!.adapter = mAdapter

    }

    override fun setRepositories(repositories: List<Repository>) {
        mAdapter!!.setItems(repositories)
        mProgress!!.visibility = View.GONE
        mRecyclerView!!.visibility = View.VISIBLE
    }
    override fun onClick(binding: ListItemBinding) {
//        Log.d("h2", "click" + binding.repo.name!!)
    }
}
