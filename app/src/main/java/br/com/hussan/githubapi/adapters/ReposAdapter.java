package br.com.hussan.githubapi.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.hussan.githubapi.BR;
import br.com.hussan.githubapi.MainActivity;
import br.com.hussan.githubapi.R;
import br.com.hussan.githubapi.databinding.ItemListBinding;
import br.com.hussan.githubapi.models.Repository;

/**
 * Created by hussan on 4/11/16.
 */
public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ViewHolder> {
    private List<Repository> mDataset;
    private MainActivity clickListener;

    public ReposAdapter() {

    }

    public interface ClickItem {
        void onClick();
    }

    public void setClickListener(MainActivity clickListener) {
        this.clickListener = clickListener;
    }

    public MainActivity getClickListener() {
        return clickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ItemListBinding binding;
        public ViewHolder(View v) {
            super(v);
            binding = DataBindingUtil.bind(v);
        }
        public ItemListBinding getBinding() {
            return binding;
        }
    }

    public void setItems(List<Repository> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public ReposAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);

        v.setOnClickListener(click -> {
            clickListener.onClick();
        });

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Repository repository = mDataset.get(position);
        holder.getBinding().setVariable(BR.repo, repository);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}