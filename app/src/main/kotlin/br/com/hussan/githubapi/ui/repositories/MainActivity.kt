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

import javax.inject.Inject

import br.com.hussan.githubapi.GithubApp
import br.com.hussan.githubapi.R
import br.com.hussan.githubapi.adapters.RepositoryAdapter
import br.com.hussan.githubapi.data.api.ApiInterface
import br.com.hussan.githubapi.data.model.Repository
import br.com.hussan.githubapi.databinding.ListItemBinding
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity(), RepositoryAdapter.ClickItem {

    @Inject
    lateinit var apiService: ApiInterface

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

        //        .subscribe(new Subscriber<List<Repository>>() {
        //            @Override
        //            public void onCompleted() {
        //                Toast.makeText(getApplicationContext(),
        //                        "Completed",
        //                        Toast.LENGTH_SHORT)
        //                        .show();
        //            }
        //
        //            @Override
        //            public void onError(Throwable e) {
        //                Toast.makeText(getApplicationContext(),
        //                        e.getMessage(),
        //                        Toast.LENGTH_SHORT)
        //                        .show();
        //            }
        //
        //            @Override
        //            public void onNext(List<Repository> repositories) {
        //                mAdapter.setItems(repositories);
        //                mAdapter.notifyDataSetChanged();
        //                mProgress.setVisibility(View.GONE);
        //                mRecyclerView.setVisibility(View.VISIBLE);
        //            }
        //        });

    }

    override fun onClick(binding: ListItemBinding) {
        Log.d("h2", "click" + binding.repo.name!!)
    }
}
