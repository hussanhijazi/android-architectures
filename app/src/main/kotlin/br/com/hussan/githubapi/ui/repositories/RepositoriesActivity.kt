package br.com.hussan.githubapi.ui.repositories

import android.graphics.PorterDuff
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import br.com.hussan.githubapi.R
import br.com.hussan.githubapi.data.RepositoryModel
import br.com.hussan.githubapi.data.model.Repository
import br.com.hussan.githubapi.databinding.ListItemBinding
import br.com.hussan.githubapi.ui.repositorydetails.RepositoryDetailsActivity
import br.com.hussan.githubapi.utils.myStartActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class RepositoriesActivity : RepositoryAdapter.ClickItem, AppCompatActivity() {

    private val TAG = RepositoriesActivity::class.java.simpleName

    private val viewModel: RepositoriesViewModel by lazy {
        RepositoriesViewModel(RepositoryModel())
    }

    private var mRecyclerView: RecyclerView? = null
    private var mProgress: ProgressBar? = null
    private var mAdapter: RepositoryAdapter? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null

    private val mDisposable = CompositeDisposable()

    companion object {
        val NAME = "NAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        initUI()

        mDisposable.add(
                viewModel.getAllRepositories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        // onNext
                        this::setRepositories,
                        // onError
                        { error -> Log.d(TAG, "Error: ", error) },
                        // onComplete
                        { Log.d(TAG, "Completed: ") }
                )
        )

    }

    private fun initUI() {
        mRecyclerView = findViewById(R.id.list_repos) as RecyclerView

        mProgress = findViewById(R.id.progress) as ProgressBar
        mProgress?.indeterminateDrawable?.setColorFilter(ContextCompat.getColor(this, R.color.colorPrimary), PorterDuff.Mode.MULTIPLY)


        mRecyclerView?.setHasFixedSize(true)

        mLayoutManager = LinearLayoutManager(this)
        mRecyclerView?.layoutManager = mLayoutManager

        mAdapter = RepositoryAdapter()
        mAdapter?.clickListener = this
        mRecyclerView?.adapter = mAdapter

    }

    private fun setRepositories(repositories: List<Repository>) {
        mAdapter?.setItems(repositories)
        mProgress?.visibility = View.GONE
        mRecyclerView?.visibility = View.VISIBLE
    }

    override fun onClick(binding: ListItemBinding) {

        Log.d("h2", "click" + binding.repo?.name)

        val bundle = Bundle().apply {
            putString(NAME, binding.repo?.name)
        }

        myStartActivity(RepositoryDetailsActivity::class.java, bundle)

    }

    override fun onDestroy() {
        super.onDestroy()

        mDisposable.dispose()
    }
}

