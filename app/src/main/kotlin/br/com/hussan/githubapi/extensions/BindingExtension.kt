package br.com.hussan.githubapi.extensions

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

open class DataBoundViewHolder<out T : ViewDataBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)
