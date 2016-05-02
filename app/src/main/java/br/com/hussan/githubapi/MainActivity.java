package br.com.hussan.githubapi;

import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import br.com.hussan.githubapi.adapters.RepositoryAdapter;
import br.com.hussan.githubapi.api.ApiClientGenerator;
import br.com.hussan.githubapi.api.ApiInterface;
import br.com.hussan.githubapi.models.Repository;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements RepositoryAdapter.ClickItem{

    private RecyclerView mRecyclerView;
    private ProgressBar mProgress;
    private RepositoryAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        callApi();

    }

    private void initUI() {
        mRecyclerView = (RecyclerView) findViewById(R.id.list_repos);

        mProgress = (ProgressBar) findViewById(R.id.progress);
        mProgress.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(this, R.color.colorPrimary), PorterDuff.Mode.MULTIPLY);


        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RepositoryAdapter();
        mAdapter.setClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void callApi() {
        ApiInterface githubService =
                ApiClientGenerator.createService(ApiInterface.class);

        Observable<List<Repository>> observable = githubService.repositories("helabs");

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(repositories -> {
                    mAdapter.setItems(repositories);
                    mProgress.setVisibility(View.GONE);
                    mRecyclerView.setVisibility(View.VISIBLE);
                });

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

    @Override
    public void onClick() {
        Log.d("h2", "click");
    }
}
