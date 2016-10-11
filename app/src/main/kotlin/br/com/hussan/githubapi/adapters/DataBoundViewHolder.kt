package br.com.hussan.githubapi.adapters

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

/**
 * Created by hussan on 5/16/16.
 */

open class DataBoundViewHolder<T : ViewDataBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)
