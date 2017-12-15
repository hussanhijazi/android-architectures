package br.com.hussan.githubapi.ui.repositories

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.hussan.githubapi.BR
import br.com.hussan.githubapi.R
import br.com.hussan.githubapi.data.model.Repository
import br.com.hussan.githubapi.databinding.ListItemBinding
import br.com.hussan.githubapi.utils.DataBoundViewHolder


/**
 * Created by hussan on 4/11/16.
 */
class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {
    private var mDataset: List<Repository>? = null
    var clickListener: ClickItem? = null

    interface ClickItem {
        fun onClick(binding: ListItemBinding)
    }

    class ViewHolder(binding: ListItemBinding) : DataBoundViewHolder<ListItemBinding>(binding)

    fun setItems(myDataset: List<Repository>) {
        mDataset = myDataset
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {

        val binding = DataBindingUtil.inflate<ListItemBinding>(LayoutInflater.from(parent.context),
                R.layout.list_item, parent, false)

        binding.root.setOnClickListener { click -> clickListener?.onClick(binding) }
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