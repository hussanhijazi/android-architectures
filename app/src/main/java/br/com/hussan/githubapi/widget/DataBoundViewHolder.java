package br.com.hussan.githubapi.widget;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

public class DataBoundViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder{

    private T binding;

    public DataBoundViewHolder(T binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
    public T getBinding()
    {
        return binding;
    }
}
