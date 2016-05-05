package br.com.hussan.githubapi.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import br.com.hussan.githubapi.BR;
import br.com.hussan.githubapi.R;
import br.com.hussan.githubapi.databinding.ListItemBinding;
import br.com.hussan.githubapi.models.Repository;


/**
 * Created by hussan on 4/11/16.
 */
public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.ViewHolder> {
    private List<Repository> mDataset;
    private RepositoryAdapter.ClickItem clickListener;

    public RepositoryAdapter() {

    }

    public interface ClickItem {
        void onClick(ListItemBinding binding);
    }

    public void setClickListener(RepositoryAdapter.ClickItem clickListener) {
        this.clickListener = clickListener;
    }

    public RepositoryAdapter.ClickItem getClickListener() {
        return clickListener;
    }

    public void setItems(List<Repository> myDataset) {
        mDataset = myDataset;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ListItemBinding binding;

        public ViewHolder(ListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public ListItemBinding getBinding() {
            return binding;
        }
    }

    @Override
    public RepositoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {


        ListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.list_item, parent, false);

        binding.getRoot().setOnClickListener(click -> {
            clickListener.onClick(binding);
        });
        return new ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.getBinding().setVariable(BR.repo, mDataset.get(position));
//        holder.getBinding().setRepo(mDataset.get(position));
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}