package br.com.hussan.githubapi.utils

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

open class DataBoundViewHolder<T : ViewDataBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)
