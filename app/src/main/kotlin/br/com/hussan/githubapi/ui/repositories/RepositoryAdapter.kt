package br.com.hussan.githubapi.ui.repositories

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.hussan.githubapi.BR
import br.com.hussan.githubapi.R
import br.com.hussan.githubapi.data.model.Repo
import br.com.hussan.githubapi.databinding.ListItemRepoBinding
import br.com.hussan.githubapi.extensions.DataBoundViewHolder

class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {
    private var mDataset: List<Repo>? = null

    class ViewHolder(binding: ListItemRepoBinding) : DataBoundViewHolder<ListItemRepoBinding>(binding)

    fun setItems(myDataset: List<Repo>) {
        mDataset = myDataset
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {

        val binding = DataBindingUtil.inflate<ListItemRepoBinding>(
            LayoutInflater.from(parent.context),
            R.layout.list_item_repo, parent, false)

        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.setVariable(BR.repo, mDataset?.get(position))
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return mDataset?.size ?: 0
    }
}