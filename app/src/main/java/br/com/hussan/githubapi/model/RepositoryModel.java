package br.com.hussan.githubapi.model;

import java.util.List;

import br.com.hussan.githubapi.data.api.ApiClientGenerator;
import br.com.hussan.githubapi.data.api.ApiInterface;
import br.com.hussan.githubapi.data.models.Repository;
import br.com.hussan.githubapi.contracts.RepositoryContract;
import br.com.hussan.githubapi.presenter.BasePresenter;
import br.com.hussan.githubapi.presenter.RepositoryPresenter;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hussan on 7/22/16.
 */

public class RepositoryModel implements RepositoryContract.Model, BaseModel {

    private RepositoryContract.Presenter mPresenter;

    public RepositoryModel(RepositoryPresenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        mPresenter = (RepositoryContract.Presenter) presenter;
    }
    
    @Override
    public void getAllRepositories() {
        ApiInterface githubService =
                ApiClientGenerator.createService(ApiInterface.class);

        Observable<List<Repository>> observable = githubService.getRepositories("helabs");

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(repositories -> {
                    mPresenter.setRepositories(repositories);
                });
//        .subscribe(new Subscriber<List<RepositoryContract>>() {
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
//            public void onNext(List<RepositoryContract> getRepositories) {
//                mAdapter.setItems(getRepositories);
//                mAdapter.notifyDataSetChanged();
//                mProgress.setVisibility(View.GONE);
//                mRecyclerView.setVisibility(View.VISIBLE);
//            }
//        });

    }

}
