package br.com.hussan.githubapi;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import net.danlew.android.joda.JodaTimeAndroid;

import java.util.List;

import br.com.hussan.githubapi.adapters.RepositoryAdapter;
import br.com.hussan.githubapi.data.models.Repository;
import br.com.hussan.githubapi.databinding.ListItemBinding;
import br.com.hussan.githubapi.presenter.RepositoryPresenter;
import br.com.hussan.githubapi.view.RepositoryView;

public class MainActivity extends AppCompatActivity implements RepositoryAdapter.ClickItem, RepositoryView {

    private RecyclerView mRecyclerView;
    private ProgressBar mProgress;
    private RepositoryAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RepositoryPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JodaTimeAndroid.init(this);

        setContentView(R.layout.activity_main);
        initUI();

        presenter = new RepositoryPresenter(this);

        presenter.getAllRepositories();

    }

    private void initUI() {
        mRecyclerView = (RecyclerView) findViewById(R.id.list_repos);

        mProgress = (ProgressBar) findViewById(R.id.progress);
        mProgress.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(this, R.color.colorPrimary), PorterDuff.Mode.MULTIPLY);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RepositoryAdapter();
        mAdapter.setClickListener(this);

        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(ListItemBinding binding) {
        Log.d("h2", "click" + binding.getRepo().getName());
    }

    @Override
    public void setRepositories(List<Repository> repositories) {
        mAdapter.setItems(repositories);
        mProgress.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }
}
